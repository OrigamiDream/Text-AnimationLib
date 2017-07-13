package av.is.animationlib.option;

import av.is.animationlib.AnimatingOption;
import av.is.animationlib.Animation;

import java.util.List;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class OptionDefault implements AnimatingOption {
    
    @Override
    public void execute(List<Animation> animations) {
        animations.get(animations.size() - 1).setNext(null);
    }
    
    @Override
    public void queryCycle() {
    
    }
    
    @Override
    public boolean isExecutable() {
        return true;
    }
}
