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

        StringBuilder empty = new StringBuilder();
        for(int i = index; i < content.length(); i++) {
            empty.append(" ");
        }
        
        animate(content.substring(0, index) + empty);
        index++;
        
        if(index == content.length() + 1) {
            finish();
        }
    }

    @Override
    public void onFinish() {
        index = 0;
    }
}
