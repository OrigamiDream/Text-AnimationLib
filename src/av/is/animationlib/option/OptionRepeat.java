package av.is.animationlib.option;

import av.is.animationlib.AnimatingOption;
import av.is.animationlib.Animation;

import java.util.List;

/**
 * Created by Avis Network on 2017-07-13.
 */
public class OptionRepeat implements AnimatingOption {
    
    public static final int ENDLESS_LOOP = -1;
    
    private int repeat;
    private int times;
    
    public OptionRepeat(int repeat) {
        this.repeat = repeat;
        this.times = 0;
    }
    
    @Override
    public void execute(List<Animation> animations) {
        animations.get(animations.size() - 1).setNext(animations.get(0));
    }
    
    @Override
    public void queryCycle() {
        if(repeat == ENDLESS_LOOP) {
            return;
        }
        times++;
    }
    
    @Override
    public boolean isExecutable() {
        return times < repeat || repeat == ENDLESS_LOOP;
    }
}
