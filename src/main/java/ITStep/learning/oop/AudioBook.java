package ITStep.learning.oop;

public class AudioBook extends Literature  implements Playable {
    private String speaker;

    public AudioBook() {
    }

    public AudioBook(String title,String speaker) {
        super.setTitle(title);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }


    @Override
    public void play() {
        System.out.println( "Playing " + this.toString() ) ;
    }
}
