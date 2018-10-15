package av.is.animationlib;

/**
 * Created by Avis Network on 2017-07-13.
 */
public interface Animation {
    
    public String getOriginalContent();
    
    public void setNext(Animation animation);
    
    public Animation getNextAnimation();
    
    public Animator getAnimator();
    
    void setAnimator(Animator animator);
    
    AnimationModifier getModifier();
    
    void setModifier(AnimationModifier modifier);
    
    public void animate(String content);
    
    public boolean isRunning();
    
    public void setRunning(boolean running);
    
    public void finish();
    
    public void onTick();

    public void onFinish();
    
    public abstract class Impl implements Animation {
        
        private final String content;
        private Animation nextAnimation;
        private Animator animator;
        private AnimationModifier modifier;
        private boolean running = false;
        
        public Impl(String content) {
            this.content = content;
        }
    
        @Override
        public String getOriginalContent() {
            return content;
        }
    
        @Override
        public void setNext(Animation animation) {
            nextAnimation = animation;
        }
        
        @Override
        public Animation getNextAnimation() {
            return nextAnimation;
        }
    
        @Override
        public Animator getAnimator() {
            return animator;
        }
    
        @Override
        public void setAnimator(Animator animator) {
            this.animator = animator;
        }
    
        @Override
        public AnimationModifier getModifier() {
            return modifier;
        }
    
        @Override
        public void setModifier(AnimationModifier modifier) {
            this.modifier = modifier;
        }
    
        @Override
        public void animate(String content) {
            getAnimator().animate(content);
        }
    
        @Override
        public boolean isRunning() {
            return running;
        }
        
        @Override
        public void setRunning(boolean running) {
            this.running = running;
        }
        
        @Override
        public void finish() {
            setRunning(false);
            onFinish();
            
            // Call event for cycling
            getModifier().queryCycle();
            if(getNextAnimation() != null) {
                getNextAnimation().setRunning(true);
            }
        }
    }
}
