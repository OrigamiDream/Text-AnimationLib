package av.is.animationlib.example;

import av.is.animationlib.Animation;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class ExampleAnimationTypingLess extends Animation.Impl {
    
    private int index;
    
    public ExampleAnimationTypingLess(String content) {
        super(content);
        
        index = content.length();
    }
    
    @Override
    public void onTick() {
        String content = getOriginalContent();
        
        animate(content.substring(0, index));
        index--;
        
        if(index < 0) {
            finish();
        }
    }
}
