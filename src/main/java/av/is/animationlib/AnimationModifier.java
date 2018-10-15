package av.is.animationlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Avis Network on 2017-07-13.
 */
public interface AnimationModifier {
    
    public AnimationModifier permutate(Animation... animations);
    
    public AnimationModifier permutate(List<Animation> animations);
    
    public Optional<AnimatingOption> option();
    
    
    /**
     * Set option to set status of animation.
     *
     * @param Option to be changed.
     */
    public AnimationModifier setOption(AnimatingOption option);
    
    
    /**
     *
     * Get animator object accessible.
     *
     * @return
     */
    public Animator getAnimator();
    
    
    /**
     * Set animator that contains display.
     *
     * @param Animator to be changed.
     */
    public AnimationModifier setAnimator(Animator animator);
    
    
    /**
     * We need scheduler to animate text.
     *
     * Call this method in your custom scheduler.
     */
    public void tick();
    
    void queryCycle();
    
    
    /**
     * Unregister and stop all animations.
     */
    public void unregister();
    
    public class Impl implements AnimationModifier {
        
        private Optional<AnimatingOption> option = Optional.empty();
        private Animator animator;
        
        @Deprecated
        private List<Animation> animations = new ArrayList<>();
    
        private final String content;
    
        public Impl(String content) {
            this.content = content;
        }
        
        @Override
        public AnimationModifier permutate(Animation... animations) {
            for(int i = 0; i < animations.length; i++) {
                if(i != animations.length - 1) {
                    animations[i].setNext(animations[i + 1]);
                }
                if(i == 0) {
                    animations[i].setRunning(true);
                }
                animations[i].setAnimator(animator);
                animations[i].setModifier(this);
                this.animations.add(animations[i]);
            }
            return this;
        }
    
        @Override
        public AnimationModifier permutate(List<Animation> animations) {
            for(int i = 0; i < animations.size(); i++) {
                Animation animation = animations.get(i);
                if(i != animations.size() - 1) {
                    animation.setNext(animations.get(i + 1));
                }
                if(i == 0) {
                    animation.setRunning(true);
                }
                animation.setAnimator(animator);
                animation.setModifier(this);
                this.animations.add(animation);
            }
            return this;
        }
    
        @Override
        public Optional<AnimatingOption> option() {
            return option;
        }
    
        @Override
        public AnimationModifier setOption(AnimatingOption option) {
            this.option = Optional.ofNullable(option);
            this.option.get().execute(animations);
            return this;
        }
    
        @Override
        public Animator getAnimator() {
            return animator;
        }
    
        @Override
        public AnimationModifier setAnimator(Animator animator) {
            this.animator = animator;
            return this;
        }
    
        @Override
        public void tick() {
            // FIXME This need to be more faster.
            if(option.isPresent()) {
                if(!option.get().isExecutable()) {
                    unregister();
                    return;
                }
            }
            for(int i = 0; i < animations.size(); i++) {
                Animation animation = animations.get(i);
                if(!animation.isRunning()) {
                    continue;
                }
                animation.onTick();
            }
        }
        
        @Override
        public void queryCycle() {
            if(option.isPresent()) {
                option.get().queryCycle();
            }
        }
    
        @Override
        public void unregister() {
            for(int i = 0; i < animations.size(); i++) {
                Animation animation = animations.get(i);
                animation.setRunning(false);
            }
            animations.clear();
            animator = null;
            option = null;
        }
    }
}
