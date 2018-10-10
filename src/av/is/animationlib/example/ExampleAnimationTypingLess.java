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

        StringBuilder empty = new StringBuilder();
        for(int i = index; i < content.length(); i++) {
            empty.append(" ");
        }

        animate(content.substring(0, index) + empty.toString());
        index--;
        
        if(index < 0) {
            finish();
        }
    }

    @Override
    public void onFinish() {
        index = getOriginalContent().length();
    }
}
