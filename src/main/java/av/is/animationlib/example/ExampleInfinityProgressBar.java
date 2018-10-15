package av.is.animationlib.example;

import av.is.animationlib.Animation;

public class ExampleInfinityProgressBar extends Animation.Impl {

    private int state = 0;
    private int dotIndex = 0;
    private int dot = 0;

    public ExampleInfinityProgressBar(String content) {
        super(content);
    }

    @Override
    public void onTick() {
        StringBuilder builder = new StringBuilder();
        builder.append("  INSTALLING");

        builder.append(" [");
        int startState = Math.max(0, state - 40);
        int endState = Math.min(100, state);
        for(int i = 0; i < 100; i++) {
            if(i >= startState && i <= endState) {
                builder.append("#");
            } else {
                builder.append("-");
            }
        }
        state++;
        if(state >= 160) {
            state = 0;
        }
        builder.append("]   ");
        animate(builder.toString());
    }

    @Override
    public void onFinish() {

    }
}
