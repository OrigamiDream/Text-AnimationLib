package av.is.animationlib.example;

import av.is.animationlib.Animation;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class ExampleAnimationTypingMore extends Animation.Impl {
    
    private int index = 0;
    
    public ExampleAnimationTypingMore(String content) {
        super(content);
    }
    
    @Override
    public void onTick() {
        String content = getOriginalContent();
        
        animate(content.substring(0, index));
        index++;
        
        if(index == content.length() + 1) {
            finish();
        }
    }
}
