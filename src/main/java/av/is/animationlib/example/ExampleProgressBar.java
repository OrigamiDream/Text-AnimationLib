package av.is.animationlib.example;

import av.is.animationlib.Animation;

public class ExampleProgressBar extends Animation.Impl {

    private int index = 0;

    public ExampleProgressBar(String content) {
        super(content);
    }

    @Override
    public void onTick() {
        StringBuilder builder = new StringBuilder();
        if(index < 99) {
            builder.append(" ");
        }
        if(index < 9) {
            builder.append(" ");
        }
        builder.append(" ").append(index + 1).append("% [");
        for(int i = 0; i <= index; i++) {
            builder.append("#");
        }
        for(int i = index + 1; i < 100; i++) {
            builder.append("-");
        }
        builder.append("]  ");

        animate(builder.toString());

        index++;
        if(index == 100) {
            finish();
        }
    }

    @Override
    public void onFinish() {
        index = 0;
    }
}
