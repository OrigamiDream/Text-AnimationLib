package av.is.animationlib;

import java.util.List;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class AnimationLib {
    
    private static AnimationLib animationLib;
    
    private AnimationLib() {
        animationLib = this;
    }
    
    /**
     *
     * Singleton.
     * The way to get AnimationLib object to easy
     *
     * @return The instance of this class.
     */
    public static AnimationLib getAnimationLib() {
        if(animationLib == null) {
            animationLib = new AnimationLib();
        }
        return animationLib;
    }
    
    public AnimationModifier createAnimation(String message, Animator animator, Animation... animations) {
        AnimationModifier modifier = new AnimationModifier.Impl(message);
        modifier.setAnimator(animator);
        modifier.permutate(animations);
        return modifier;
    }
    
    public AnimationModifier createAnimation(String message, Animator animator, List<Animation> animations) {
        AnimationModifier modifier = new AnimationModifier.Impl(message);
        modifier.setAnimator(animator);
        modifier.permutate(animations);
        return modifier;
    }
}
