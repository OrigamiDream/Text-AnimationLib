package av.is.animationlib.example;

import av.is.animationlib.Animation;

public class ExampleAnimationLowUpCase extends Animation.Impl {

    private int index = 0;

    public ExampleAnimationLowUpCase(String content) {
        super(content);
    }

    @Override
    public void onTick() {
        String content = getOriginalContent();

        StringBuilder builder = new StringBuilder();

        int startIndex = Math.max(0, index - 5);
        int endIndex = Math.min(content.length() - 1, index);

        char c;
        for(int i = 0; i < content.length(); i++) {
            c = content.charAt(i);
            if(i >= startIndex && i <= endIndex) {
                builder.append(String.valueOf(c).toUpperCase());
            } else {
                builder.append(c);
            }
        }
        animate(builder.toString());
        index++;

        if(index == content.length() + 5) {
            finish();
        }
    }

    @Override
    public void onFinish() {
        index = 0;
    }
}
