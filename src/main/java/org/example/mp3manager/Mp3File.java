package org.example.mp3manager;
import java.io.File;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;


/**
 * A simple class that allows a user to access and change the 
 * pathname, author, album, title and date of an mp3 file.
 * Mp3 files can also be played. Basically this class
 * represents some information about an Mp3 file.
 */
public class Mp3File {
    private String pathname, author, album, date, title;
    private int year;

    /**
     * Creates an Mp3File.
     * @param pathname the file path of the Mp3 file
     */
    public Mp3File(String pathname) {
        this.pathname = pathname;
        try {
            AudioFileFormat mpegFormat = AudioSystem.getAudioFileFormat(new File(pathname));
            @SuppressWarnings("rawtypes")
            Map props = mpegFormat.properties();
            author = (String) props.get("author");
            album  = (String) props.get("album");
            title  = (String) props.get("title");
            date   = (String) props.get("date");
            try {
                year = (date != null && !date.isEmpty()) ? Integer.parseInt(date) : 0;
            } catch (NumberFormatException ignore) {
                year = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * Returns the pathname of the Mp3File.
     * @return pathname of the Mp3File
     */
    public String getPath() {
        return pathname;
    }

    /**
     * Sets the pathname of the Mp3File.
     * @param pathname the pathname of the Mp3File
     */
    public void setPath(String pathname) {
        this.pathname = pathname;
    }

    /**
     * Returns the author of the Mp3File.
     * @return author of the Mp3File
     */
    public String getAuthor() { return (author == null || author.isEmpty()) ? "Unknown" : author; }

    /**
     * Sets the author of the Mp3File.
     * @param author the author of the Mp3File
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns the album of the Mp3File.
     * @return album of the Mp3File
     */
    public String getAlbum()  { return (album  == null || album.isEmpty())  ? "Unknown" : album; }

    /**
     * Sets the album of the Mp3File.
     * @param album the album of the Mp3File
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Returns the date of the Mp3File.
     * @return date of the Mp3File
     */
    public String getDate()   { return (date   == null || date.isEmpty())   ? "1900"    : date; }

    /**
     * Sets the date of the Mp3File.
     * @param date the date of the Mp3File
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the title of the Mp3File.
     * @return title of the Mp3File
     */
    public String getTitle()  { return (title  == null || title.isEmpty())  ? "Unknown" : title; }

    /**
     * Sets the title of the Mp3File.
     * @param title the title of the Mp3File
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the year of the Mp3File.
     * @return year of the Mp3File
     */
    public int getYear()      { return year; }
    /**
     * Sets the year of the Mp3File.
     * @param year the year of the Mp3File
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the author, title, album and date of the Mp3File.
     * @return a string with author, title, album and date
     */
    public String toString() {
        return "Author: " + author + "\nTitle: " + title + "\nAlbum: " + album + "\nDate: " + date;
    }

    /**
     * Returns true if this Mp3File equals another Mp3File.
     * @param m another Mp3File
     * @return true if all metadata fields are equal
     */
    public boolean equals(Mp3File m) {
        return m.author.equals(author) && m.title.equals(title) && m.album.equals(album) && m.date.equals(date);
    }

    /**
     * Plays the Mp3File.
     */
    public void play() {
        MP3Player player = new MP3Player();
        player.play(pathname);
    }
}