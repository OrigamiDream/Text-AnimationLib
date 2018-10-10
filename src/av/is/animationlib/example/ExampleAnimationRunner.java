package av.is.animationlib.example;

import av.is.animationlib.AnimationLib;
import av.is.animationlib.AnimationModifier;
import av.is.animationlib.option.OptionDefault;
import av.is.animationlib.option.OptionRepeat;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class ExampleAnimationRunner {
    
    public static void main(String args[]) {
        String message = "abcdefghijklmnopqrstuvwxyz";
        
        AnimationModifier modifier = AnimationLib.getAnimationLib().createAnimation(message, text -> {
                    System.out.print('\r');
                    System.out.print(text);
            }, new ExampleAnimationTypingMore(message), new ExampleAnimationLowUpCase(message), new ExampleAnimationTypingLess(message));
        
        modifier.setOption(new OptionRepeat(OptionRepeat.ENDLESS_LOOP));
        
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
