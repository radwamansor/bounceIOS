/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radwa Manssour
 */
class Player {
    private String name,pass;
    private int score;
    private String image;

    public Player(String name, String pass, int score, String image) {
        this.name = name;
        this.pass = pass;
        this.score = score;
        this.image = image;
    }

    
    public String getImage() {
        return image;
    }

    public String getPass() {
        return pass;
    }
    
    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
    
}
