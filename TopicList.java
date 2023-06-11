package OOP;

import java.awt.*;
import java.util.*;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class TopicList {
    private final List<Topic> topics;
    private TopicScreen topic_screen;

    public List<Topic> get_topics() {
        return topics;
    }

    public void set_topic_screen(TopicScreen topic_screen) {
        this.topic_screen = topic_screen;
    }

    // Constructor
    public TopicList(GUI gui, TopicScreen topic_screen) throws UnsupportedAudioFileException, IOException {
        set_topic_screen(topic_screen);

        // Populate the topics

        topics = new LinkedList<>();

        // Topic 1: Music theory
        Topic topic1 = new Topic("Music Theory", "image\\MusicTheory.png", gui, this.topic_screen);
        topic1.add_question(new Question("How many sharps are in the A minor key?", List.of("0", "1", "2", "3"), "0", false));
        topic1.add_question(new Question("What is the relationship between these two notes?", List.of("Unison", "Enharmonic", "Octave", "Relative"), "Enharmonic", "image\\1.png", new Dimension(550, 250), false));
        topic1.add_question(new Question("The song in the audio is in a minor key.", List.of("True", "False"), "True", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\1.wav", false));
        topic1.add_question(new Question("Which musical term indicates a gradual increase in volume?", List.of("Pianissimo", "Forte", "Crescendo", "Decrescendo"), "Crescendo", false));
        topic1.add_question(new Question("A major and minor scale with the same tonic note are called _____ keys.", List.of("Oblique", "Perpendicular", "Intersecting", "Parallel"), "Parallel", false));
        topic1.add_question(new Question("A sudden shift from one key to another in a musical composition is called?", List.of("Transposition", "Modulation", "Chromaticism", "Suspension"), "Modulation", false));
        topic1.add_question(new Question("What does 'legato' mean?", List.of("Smooth and connected", "Loud and powerful", "Short and detached", "Soft and delicate"), "Smooth and connected", false));
        topic1.add_question(new Question("What musical term indicates a gradual decrease in volume?", List.of("Crescendo", "Forte", "Pianissimo", "Decrescendo"), "Decrescendo", false));
        topic1.add_question(new Question("A musical ornament consisting of a rapid alternation between 2 adjacent notes:", List.of("Glissando", "Trill", "Acciaccatura", "Tremolo"), "Trill", false));
        topic1.add_question(new Question("Which term means a gradual slowing down of tempo in a piece?", List.of("Coda", "Ritardando", "Fermata", "Accelerando"), "Ritardando", false));
        topic1.add_question(new Question("3/4 is an example of a/an _____.", List.of("Musical ornament", "Key signature", "Time signature", "Tempo marking"), "Time signature", false));
        topic1.add_question(new Question("_____ is the distance between two pitches.", List.of("Chord", "Cadence", "Counterpoint", "Interval"), "Interval", false));
        topic1.add_question(new Question("A _____ is a compositional technique where a melody plays and imitations of that melody play after a given duration.", List.of("Canon", "Sonata", "Etude", "Sonatina"), "Canon", false));
        topic1.add_question(new Question("What interval is the devil's interval?", List.of("Diminished fifth", "Augmented fifth", "Diminished fourth", "Augmented fourth"), "Augmented fourth", false));
        topic1.add_question(new Question("Which of these is a synonym to 'decrescendo'?", List.of("Doloroso", "Diminuendo", "Dolce", "Declamando"), "Diminuendo", false));
        topic1.add_question(new Question("What term denotes a return to the original tempo?", List.of("A tempo", "Tempo a", "1 Tempo", "Tempo 1"), "A tempo", false));
        topic1.add_question(new Question("3/4 and 6/8 are the same time signatures.", List.of("True", "False"), "False", false));
        topic1.add_question(new Question("A concerto features a soloist accompanied by an orchestra.", List.of("True", "False"), "True", false));
        topic1.add_question(new Question("A syncopated rhythm puts accents on the weak beats.", List.of("True", "False"), "True", false));
        topic1.add_question(new Question("The term 'adagio' indicates a fast tempo.", List.of("True", "False"), "False", false));
        topic1.add_question(new Question("An accidental in music notation is a symbol that alters the pitch of a note.", List.of("True", "False"), "True", false));
        topic1.add_question(new Question("The top number in a time signature is the note value that represents one beat.", List.of("True", "False"), "False", false));
        topic1.add_question(new Question("What is the name of this symbol?", List.of("Fine", "Coda", "Da Capo", "Dal Segno"), "Coda", "image\\2.png", new Dimension(300,300), false));
        topic1.add_question(new Question("The chord being shown is F#m7.", List.of("True","False"), "False", "image\\3.png", new Dimension(550, 250), false));
        topic1.add_question(new Question("Tbe value of each of the three visible notes is _____ beat(s)", List.of("2", "3/2", "1", "4/3"), "4/3", "image\\4.png", new Dimension(550, 250), false));
        topic1.add_question(new Question("The ornament shown in the image is a staccato", List.of("True", "False"), "True", "image\\5.png", new Dimension(300, 300), false));
        topic1.add_question(new Question("The cadence being played is called the perfect cadence.", List.of("True", "False"), "False", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\2.wav", false));
        topic1.add_question(new Question("The chord being played is:", List.of("G", "Gm", "Gdim", "Gaug"), "Gaug", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\3.wav", false));
        topic1.add_question(new Question("The audio plays the first 8 bars of Lace, an OST from Silksong, which uses an irregular time signature. What is this time signature?", List.of("3/2", "5/4", "7/8", "15/16"), "5/4", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\4.wav", false));
        topic1.add_question(new Question("What technique is being used in this audio clip?", List.of("Spiccato", "Col legno", "Pizzicato", "Vibrato"), "Pizzicato", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\5.wav", false));

        // Topic 2: General knowledge & Trivia
        Topic topic2 = new Topic("General knowledge & Trivia", "image\\General.png", gui, this.topic_screen);
        topic2.add_question(new Question("Generally, what instrument is considered the 'king of instruments'?", List.of("Piano", "Violin", "Trumpet", "Organ"), "Organ", false));
        topic2.add_question(new Question("Who composed 'Für Elise'?", List.of("Bach", "Chopin", "Beethoven", "Mozart"), "Beethoven", false));
        topic2.add_question(new Question("Who is often referred to as the 'King of Pop'?", List.of("Michael Jackson", "Elvis Presley", "Prince", "Stevie Wonder"), "Michael Jackson", false));
        topic2.add_question(new Question("Which musical instrument is also known as the 'Mississippi saxophone'?", List.of("Didgeridoo", "Banjo", "Harmonica", "Ukulele"), "Harmonica", false));
        topic2.add_question(new Question("Which band is known for their hit song 'Bohemian Rhapsody'?", List.of("The Beatles", "Led Zeppelin", "Rolling Stones", "Queen"), "Queen", false));
        topic2.add_question(new Question("What is the name of the instrument typically associated with Scotland?", List.of("Accordion", "Bagpipes", "Banjo", "Ukulele"), "Bagpipes", false));
        topic2.add_question(new Question("What is the largest and lowest-pitched instrument in the string family?", List.of("Viola", "Double bass", "Violin", "Cello"), "Double bass", false));
        topic2.add_question(new Question("Which famous female singer-songwriter wrote the hit song 'Rolling in the Deep'?", List.of("Adele", "Taylor Swift", "Rihanna", "Beyoncé"), "Adele", false));
        topic2.add_question(new Question("Which composer is known for his 'Fifth Symphony' with its distinct four-note opening?", List.of("Bach", "Chopin", "Beethoven", "Mozart"), "Beethoven", false));
        topic2.add_question(new Question("Which musical instrument has the highest pitch in an orchestra?", List.of("Trumpet", "Violin", "Flute", "Piccolo"), "Piccolo", false));
        topic2.add_question(new Question("Which musical instrument is also known as the 'fiddle' in certain genres of music?", List.of("Double bass", "Violin", "Viola", "Cello"), "Violin", false));
        topic2.add_question(new Question("Which artist released the hit single 'Shape of You'?", List.of("Justin Bieber", "Taylor Swift", "Ed Sheeran", "Bruno Mars"), "Ed Sheeran", false));
        topic2.add_question(new Question("(Did you listen to Shaan's presentation?)<br>A tabla consists of ___ hand drum(s) and is a _____.", List.of("one, string", "two, string", "one, percussion", "two, percussion"), "two, percussion", false));
        topic2.add_question(new Question("What is the standard tuning for a guitar's strings from lowest to highest pitch?", List.of("DGCFAD", "EADGBE", "EBGDAE", "BEADGC"), "EADGBE", false));
        topic2.add_question(new Question("What is the standard time signature of a waltz?", List.of("3/4", "4/4", "6/8", "2/2"), "3/4", false));
        topic2.add_question(new Question("What is the standard number of strings on a violin?", List.of("3", "4", "5", "6"), "4", false));
        topic2.add_question(new Question("Which instrument is a member of the brass family?", List.of("Clarinet", "Flute", "Violin", "Trombone"), "Trombone", false));
        topic2.add_question(new Question("Who is the devil's violinist?", List.of("Giuseppe Tartini", "Niccolò Paganini", "Johann Sebastian Bach", "Niccolò Amati"), "Niccolò Paganini", false));
        topic2.add_question(new Question("The saxophone is a member of the brass instrument family.", List.of("True", "False"), "False", false));
        topic2.add_question(new Question("A capella music is performed without any instrumental accompaniment.", List.of("True", "False"), "True", false));
        topic2.add_question(new Question("An erhu traditional Japanese three-stringed musical instrument.", List.of("True", "False"), "False", false));
        topic2.add_question(new Question("In a standard drum set, the bass drum is the largest drum.", List.of("True", "False"), "True", false));
        topic2.add_question(new Question("Franz Schubert is famous for his 'Four Seasons' violin concertos?", List.of("True", "False"), "False", false));
        topic2.add_question(new Question("Flamenco music and dance originated from Spain.", List.of("True", "False"), "True", false));
        topic2.add_question(new Question("What is the name of this instrument", List.of("Bongos", "Timpani", "Castanets", "Drums"), "Timpani", "image\\6.jpg", new Dimension(500,250), false));
        topic2.add_question(new Question("This scene is from an iconic music video. What is the title of the song?", List.of("Bohemian Rhapsody", "Don't Stop Believin'", "Take On Me", "Sweet Child o' Mine"), "Take On Me", "image\\7.jpg", new Dimension(500, 250), false));
        topic2.add_question(new Question("This image shows the Nikon at Jones Beach Theatre, a famous amphitheatre.", List.of("True", "False"), "False", "image\\8.jpg", new Dimension(500, 300), false));
        topic2.add_question(new Question("The name of this piece is 'Flight of a Bumblebee'", List.of("True", "False"), "False", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\6.wav", false));
        topic2.add_question(new Question("The audio plays a portion of a famous guitar solo. What song is this guitar solo from?", List.of("Breaking the Chains", "<html><div style = 'text-align: center'>Through the Fire<br>and Flames</div></html>", "Fury of the Storm", "Valley of the Damned"), "<html><div style = 'text-align: center'>Through the Fire<br>and Flames</div></html>", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\7.wav", false));
        topic2.add_question(new Question("A well-known song, but do you know the title?", List.of("Love's Melody", "Mariage d'Amour", "Serenade in G minor", "Rondo of Romance"), "Mariage d'Amour", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\8.wav", false));

        // Topic 3: Sheet music
        Topic topic3 = new Topic("Sheet music", "image\\SheetMusic.png", gui, this.topic_screen);
        topic3.add_question(new Question("The note shown is enharmonic to?", List.of("C", "G#", "A", "Bb"), "A", "image\\11.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("What is the 8 above the notes mean?", List.of("Repeat section twice", "Play 1 octave higher", "Repeat section 8 times", "Play 1 octave lower"), "Play 1 octave higher", "image\\12.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("What note is shown?", List.of("B", "C", "D", "E"), "E", "image\\13.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("Which key has this key signature?", List.of("E minor", "C# minor", "G# major", "A major"), "C# minor", "image\\14.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("What key signature does this symbol represent?", List.of("2/2", "4/4", "8/8", "16/16"), "2/2", "image\\15.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("If this is played, how many measures will be played in total? (Quality on this one is horrible, but you can still see the important parts)", List.of("7", "11", "12", "14"), "11", "image\\16.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("What does 'pp' mean?", List.of("Play moderately", "Play loudly", "Play softly", "REDACTED"), "Play softly", "image\\17.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("How many seconds does this measure take to play?", List.of("2", "0.5", "4", "1"), "2", "image\\18.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("The ornament shown is for violins. How should the note be played?", List.of("With a down bow", "With pizzicato", "With spiccato", "With an up bow"), "With an up bow", "image\\19.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("How many times is the open hi hat hit?", List.of("1", "2", "4", "12"), "1", "image\\20.png", new Dimension(500, 250), false));
        topic3.add_question(new Question("Which of these is the key signature for B major?", List.of("image\\21.png", "image\\22.png", "image\\23.png", "image\\24.png"), "image\\24.png", true));
        topic3.add_question(new Question("Which of these show correct grouping for the 6/8 time signature?", List.of("image\\25.png", "image\\26.png", "image\\28.png", "image\\27.png"), "image\\28.png", true));
        topic3.add_question(new Question("Which of these is the F melodic minor scale?", List.of("image\\32.png", "image\\31.png", "image\\30.png", "image\\29.png"), "image\\31.png", true));
        topic3.add_question(new Question("Which of these show all 4 inversions of the dominant 7th chord of the C major key?", List.of("image\\33.png", "image\\34.png", "image\\35.png", "image\\36.png"), "image\\33.png", true));
        topic3.add_question(new Question("Which of these is the start of Baka Mitai's chorus?", List.of("image\\38.png", "image\\37.png", "image\\39.png", "image\\40.png"), "image\\37.png", true));
        topic3.add_question(new Question("Which is the correct perfect fifth up transposition?", List.of("image\\42.png", "image\\43.png", "image\\44.png", "image\\45.png"), "image\\42.png", "image\\41.png", new Dimension(500,250), true));
        topic3.add_question(new Question("Which choice is equivalent to the image?", List.of("image\\47.png", "image\\48.png", "image\\49.png", "image\\50.png"), "image\\50.png", "image\\46.png", new Dimension(500,250), true));
        topic3.add_question(new Question("Which choice has the same length in beats as the image?", List.of("image\\53.png", "image\\52.png", "image\\54.png", "image\\55.png"), "image\\52.png", "image\\51.png", new Dimension(600,200), true));
        topic3.add_question(new Question("Which choice shows the exact same note as the image?", List.of("image\\59.png", "image\\58.png", "image\\60.png", "image\\57.png"), "image\\60.png", "image\\56.png", new Dimension(500,250), true));
        topic3.add_question(new Question("Which choice is the same as the image?", List.of("image\\64.png", "image\\63.png", "image\\62.png", "image\\65.png"), "image\\63.png", "image\\61.png", new Dimension(600,250), true));
        topic3.add_question(new Question("Which of these staffs are usually used for pianos when both hands are used to play.", List.of("Ensemble Staff", "Treble Staff", "Grand Staff", "Alto Staff"), "Grand Staff", false));
        topic3.add_question(new Question("What does a dot placed after a note indicate in regards to the note's length??", List.of("+ 50%", "+ 1", "- 50%", "- 1"), "+ 50%", false));
        topic3.add_question(new Question("What is the function of a double barline in sheet music?", List.of("To repeat sections", "Indicate key change", "Change time signature", "Mark the end"), "Mark the end", false));
        topic3.add_question(new Question("What is the use of ledger lines in sheet music?", List.of("Mark different sections", "Denote appoggiaturas", "Mark repeats", "Extend the staff"), "Extend the staff", false));
        topic3.add_question(new Question("Every note length in sheet music has a counterpart, which is silence of the same duration. What is the name of it?", List.of("Timeout", "Sleep", "Rest", "Offbeat"), "Rest", false));
        topic3.add_question(new Question("These four choices have different ornaments. Which is the one you hear in the audio?", List.of("image\\66.png", "image\\67.png", "image\\68.png", "image\\69.png"), "image\\69.png", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\15.wav", true));
        topic3.add_question(new Question("The rhythm is always correct, but only one choice has the correct pitches. Which one is it?", List.of("image\\71.png", "image\\72.png", "image\\70.png", "image\\73.png"), "image\\70.png", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\16.wav", true));
        topic3.add_question(new Question("The pitches are always correct, but only one choice has the correct rhythm. Which one is it?", List.of("image\\76.png", "image\\77.png", "image\\75.png", "image\\74.png"), "image\\77.png", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\17.wav", true));
        topic3.add_question(new Question("The audio plays an interval. Which of these choices show the same type of interval?", List.of("image\\78.png", "image\\79.png", "image\\80.png", "image\\81.png"), "image\\78.png", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\18.wav", true));
        topic3.add_question(new Question("Which choice shows the key signature of the song being played?", List.of("image\\82.png", "image\\83.png", "image\\84.png", "image\\85.png"), "image\\82.png", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\19.wav", true));



        // Topic 4: Music Genres and Video Game Music
        Topic topic4 = new Topic("Music Genres and Video Game Music", "image\\Game.png", gui, this.topic_screen);
        topic4.add_question(new Question("Which music genre incorporates electronic music techniques and instruments to create a repetitive, hypnotic rhythm often associated with dance music?", List.of("Country", "Techno", "Blues", "Reggae"), "Techno", false));
        topic4.add_question(new Question("Which music genre originated in the Appalachian region of the United States and is characterized by its acoustic instruments, storytelling lyrics, and vocal harmonies?", List.of("Folk", "Pop", "Soul", "Blues"), "Folk", false));
        topic4.add_question(new Question("200step is a subgenre of electronic music. Why is it called so?", List.of("Named after an artist", "It has a bpm of 200", "<html><div style = 'text-align: center'>Number of steps<br>to produce it</div></html>", "<html><div style = 'text-align: center'>Derived from the complex use<br>of rhythms and patterns</div></html>"), "It has a bpm of 200", false));
        topic4.add_question(new Question("_____ originates from Jamaica and is the parent of Reggae.", List.of("Ska", "Sky", "Ske", "Ski"), "Ska", false));
        topic4.add_question(new Question("Which music genre is associated with artists like Elvis Presley, Jerry Lee Lewis, and Chuck Berry?", List.of("Jazz", "Country", "Blues", "Rock and Roll"), "Rock and Roll", false));
        topic4.add_question(new Question("_____ is a musical genre that originates from Brazil, which is a relaxed style of samba.", List.of("Bossa nova", "Salsa", "Tango", "Rumba"), "Bossa nova", false));
        topic4.add_question(new Question("Which subgenre of metal music is known for its aggressive sound, heavily distorted guitars, and screamed or growled vocals?", List.of("Nu Metal", "Death Metal", "Power Metal", "Black Metal"), "Death Metal", false));
        topic4.add_question(new Question("_____ is an unofficial genre of electronic music that combines instrumental/orchestral leads with electronic music.", List.of("Orchestral Rave", "Synthwave", "Artcore", "Techno Fusion"), "Artcore", false));
        topic4.add_question(new Question("Which video game introduced dynamic music?", List.of("<html><div style = 'text-align: center'>The Legend of Zelda:<br>Ocarina of Time</div></html>", "Frogger", "Deus Ex", "Snake"), "Frogger", false));
        topic4.add_question(new Question("What sound design aims to create realistic and immersive sounds by recording and manipulating objects and materials?", List.of("Synthesis", "Ambience", "Atmospheric", "Foley"), "Foley", false));
        topic4.add_question(new Question("In video game music, what does the term 'leitmotif' refer to?", List.of("<html><div style = 'text-align: center'>A technique of composing<br>music for boss battles</div></html>", "<html><div style = 'text-align: center'>A type of rhythmic pattern<br>used in game music</div></html>", "<html><div style = 'text-align: center'>A recurring musical theme<br>associated with a<br>character/idea</div></html>", "<html><div style = 'text-align: center'>The main theme song<br>of a game</div></html>"), "<html><div style = 'text-align: center'>A recurring musical theme<br>associated with a<br>character/idea</div></html>", false));
        topic4.add_question(new Question("Undertale mainly uses a style of music known as 8-bit music. How are sounds made in 8-bit music?", List.of("<html><div style = 'text-align: center'>By recording real instruments<br>and converting them<br>to digital</div></html>", "<html><div style = 'text-align: center'>By using synthesizers and<br>MIDI controllers</div></html>", "<html><div style = 'text-align: center'>By utilizing software algorithms<br>to generate sounds</div></html>", "<html><div style = 'text-align: center'>By programming sound chips<br>from vintage machines.</div></html>"), "<html><div style = 'text-align: center'>By programming sound chips<br>from vintage machines.</div></html>", false));
        topic4.add_question(new Question("Which game genre is often associated with fast-paced electronic or techno music to enhance the gameplay experience?", List.of("Racing games", "RPGs", "Puzzle games", "Strategy games"), "Racing games", false));
        topic4.add_question(new Question("_____ is a field of academic research for video game music", List.of("Gamemusicology", "Ludomusicology", "Musicology", "Ludology"), "Ludomusicology", false));
        topic4.add_question(new Question("_____ is a technique studios use that takes various tracks from unrelated sources and randomly synchronize them to make a final composition.", List.of("Xenophony", "Xenochronii", "Xenochrony", "Xenophonii"), "Xenochrony", false));
        topic4.add_question(new Question("Classical music is exclusively instrumental and does not include any vocal compositions.", List.of("True", "False"), "False", false));
        topic4.add_question(new Question("Classical music refers only to the music composed during the Classical period (1750-1820).", List.of("True", "False"), "False", false));
        topic4.add_question(new Question("The Tetris theme's actually name is 'Korobeiniki', a Russian folk song.", List.of("True", "False"), "True", false));
        topic4.add_question(new Question("Opera is primarily sung and features elaborate stage productions with vocal performers accompanied by an orchestra.", List.of("True", "False"), "True", false));
        topic4.add_question(new Question("Shotgun Psystyle is a subgenre of EDM coined by Camellia.", List.of("True", "False"), "False", false));
        topic4.add_question(new Question("What is the genre being shown in this picture (good luck)", List.of("Hip Hop", "Rhythm and Blues", "Bossa Nova", "Rock & Roll"), "Bossa Nova", "image\\9.jpg", new Dimension(500, 250), false));
        topic4.add_question(new Question("What is the time signature of this song? :)", List.of("4/4", "5/4", "8/8", "7/8"), "7/8", "image\\10.jpeg", new Dimension(500, 250), false));
        topic4.add_question(new Question("Whose boss theme is this?", List.of("Svarog", "Gepard", "Cocolia", "Doomsday Beast"), "Cocolia", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\9.wav", false));
        topic4.add_question(new Question("What genre of music is this?", List.of("Chillwave", "Lo-fi", "Glitchhop", "Ambient"), "Lo-fi", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\10.wav", false));
        topic4.add_question(new Question("Based on this audio, which area would it fit in? (It's fine if you don't know these areas, the music should suffice as a hint.)", List.of("Crystal Peaks", "Forgotten Crossroads", "Ancient Basin", "Greenpath"), "Greenpath", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\11.wav", false));
        topic4.add_question(new Question("What is the genre of this song?", List.of("Progressive Rock", "Power Metal", "Jazz Fusion Metal", "Symphonic Speed Metal"), "Symphonic Speed Metal", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\12.wav", false));
        topic4.add_question(new Question("This song's genre is a subgenre of EDM. What is it?", List.of("Artcore", "Drum and Bass", "Happy Hardcore", "Future Bass"), "Artcore", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\13.wav", false));
        topic4.add_question(new Question("What song is this?", List.of("Canon in D", "Megalovania", "Baka Mitai", "We are number one"), "Megalovania", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\14.wav", false));
        topic4.add_question(new Question("This song is themed around a certain mythological creature. Which one is it?", List.of("<html><div style = 'text-align: center'>Arachne,<br>a girl turned spider.</div></html>", "<html><div style = 'text-align: center'>Ocypete,<br>a harpy.</div></html>", "<html><div style = 'text-align: center'>Lorelei, <br> a siren.</div></html>", "<html><div style = 'text-align: center'>Medusa,<br>a gorgon.</div></html>"), "<html><div style = 'text-align: center'>Lorelei, <br> a siren.</div></html>", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\20.wav", false));
        topic4.add_question(new Question("This is ______ to my master, this is a ____ you cannot ____.", List.of("my massage, light, win", "a message, fight, win", "a message, light, ween", "my message, fight, win"), "my message, fight, win", "C:\\Users\\Brandon Salim\\IdeaProjects\\Data_structures\\src\\OOP\\audio\\21.wav", false));

        // Rickroll topic
        Topic topic5 = new Topic("???", "image\\QuestionMark.png", gui, this.topic_screen);

        // Add everything to topic list
        topics.add(topic1);
        topics.add(topic2);
        topics.add(topic3);
        topics.add(topic4);
        topics.add(topic5);
    }
}
