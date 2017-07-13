package av.is.animationlib;

import java.util.List;

/**
 * Created by Avis Network on 2017-07-13.
 */
public interface AnimatingOption {
    
    public void execute(List<Animation> animations);
    
    public void queryCycle();
    
    public boolean isExecutable();
    
}
