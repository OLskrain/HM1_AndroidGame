package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    Texture texture;
    Vector2 position;
    Vector2 velocity;

    public Asteroid(float x, float y, float vx, float vy) {
        this.texture = new Texture("asteroid64.png");
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(vx, vy);
    }

    public void render (SpriteBatch batch){
        batch.draw(texture, position.x - texture.getWidth()/2, position.y - texture.getHeight()/2,32,32,64,64,1,1,0,0,0,64,64,false,false);
    }

    public void update(float dt){
        position.mulAdd(velocity, dt);
        velocity.y -= 200 * dt;
        if(position.x > 1312){
            position.x = -32;
           // position = new Vector2(- 32, position.y); не стоит этого использовать, так как мы создаем новый объект, что не хорошо в андройде
        }
        if(position.x < - 32){
            position.x = 1312;
          //  position = new Vector2(1312, position.y);
        }
        if(position.y - 32 < 0){
            position.y = 32;
            velocity.y *= - 1f;
        }
        if(position.y + 32 > 720){
            position.y = 688;
            velocity.y *= - 1f;
        }
    }
}
