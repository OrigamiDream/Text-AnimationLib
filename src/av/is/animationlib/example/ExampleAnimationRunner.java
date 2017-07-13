package av.is.animationlib.example;

import av.is.animationlib.AnimationLib;
import av.is.animationlib.AnimationModifier;
import av.is.animationlib.option.OptionDefault;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class ExampleAnimationRunner {
    
    public static void main(String args[]) {
        String message = "Hello, world!!";
        
        AnimationModifier modifier = AnimationLib.getAnimationLib().createAnimation(message, System.out::println,
                new ExampleAnimationTypingMore(message),
                new ExampleAnimationTypingLess(message));
        
        modifier.setOption(new OptionDefault());
        
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(50L);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                modifier.tick();
            }
        }).start();
    }
    
}
