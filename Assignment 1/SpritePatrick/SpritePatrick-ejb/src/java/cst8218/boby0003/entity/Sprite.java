/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.boby0003.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Purpose: The Purpose of the Sprite class is meant to be a blueprint for the Sprite object.
 * 
 * @author tgk
 */
@Entity
@XmlRootElement
public class Sprite implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static Random random = new Random();

    final static int SIZE = 10;
    final static int MAX_SPEED = 5;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    @Min(0)
    private Integer panelWidth;
    @Column
    @Min(0)
    private Integer panelHeight;
    @Column
    @Min(0)
    private Integer x;
    @Column
    @Min(0)
    private Integer y;
    @Column
    @Min(0)
    private Integer dx;
    @Column
    @Min(0)
    private Integer dy;
    @Column
    private Color color = Color.BLUE;

    public Sprite() {
    }

    public Sprite(Integer height, Integer width) {
        this.panelWidth = width;
        this.panelHeight = height;
        x = random.nextInt(width);
        y = random.nextInt(height);
        dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
        dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
    }

    public Sprite(Integer height, Integer width, Color color) {
        this(height, width);
        this.color = color;
    }

    public Integer getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(Integer panelWidth) {
        this.panelWidth = panelWidth;
    }

    public Integer getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(Integer panelHeight) {
        this.panelHeight = panelHeight;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getDy() {
        return dy;
    }

    public void setDy(Integer dy) {
        this.dy = dy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {

        // check for bounce and make the ball bounce if necessary
        //
        if (x < 0 && dx < 0) {
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0) {
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > panelWidth - SIZE && dx > 0) {
            //bounce off the right wall
            x = panelWidth - SIZE;
            dx = -dx;
        }
        if (y > panelHeight - SIZE && dy > 0) {
            //bounce off the bottom wall
            y = panelHeight - SIZE;
            dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprite)) {
            return false;
        }
        Sprite other = (Sprite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * This method takes another Sprite object and copies the information over.
     * 
     * @param entity The older Sprite to be copied to another Sprite
     */
    public void updates (Sprite entity){
        
        if (entity.getDx() != null)
            this.dx = entity.getDx();
        
        if (entity.getDy() != null)
            this.dy = entity.getDy();
           
        if (entity.getPanelHeight() != null)
            this.panelHeight = entity.getPanelHeight();
           
        if (entity.getPanelWidth() != null)
            this.panelWidth = entity.getPanelWidth();
           
        if (entity.getX() != null)
            this.x = entity.getX();
           
        if (entity.getY() != null)
            this.y = entity.getY();
        }
    
    public Boolean check(){
        
        return !(this.dx == null || this.dy == null || this.x == null || this.y == null
                || this.panelWidth == null || this.panelHeight == null);
    }
    
    public void setDefault(){
        
        if (this.dx == null)
            this.dx = 1;
        
        if (this.dy == null)
            this.dy = 1;
           
        if (this.panelHeight == null)
            this.panelHeight = 1;
           
        if (this.panelWidth == null)
            this.panelWidth = 1;
           
        if (this.x == null)
            this.x = 1;
           
        if (this.y == null)
            this.y = 1;
    }
    
    @Override
    public String toString() {
        return "entities.Sprite[ id=" + id + " ]";
    }

}
