/**
 * Matthew Samms
 * NBCC
 */
package work.nbcc.mattsamms.roshambo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Rochambo r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        r = new Rochambo();
        int move = Integer.parseInt(view.getTag().toString());
        r.playerMakesMove(move);
        int playerMove = r.getPlayerMove();
        int compMove = r.getGameMove();
        setImage((ImageView)findViewById(R.id.computer_image), compMove);
        setImage((ImageView)findViewById(R.id.player_image), playerMove);
        TextView txt = findViewById(R.id.display_winner);
        txt.setText(r.winLoseOrDraw());
    }

    private void setImage(ImageView iview, int value){
        switch (value){
            case Rochambo.ROCK:
                iview.setImageResource(R.drawable.rock);
                break;
            case Rochambo.PAPER:
                iview.setImageResource(R.drawable.paper);
                break;
            case Rochambo.SCISSOR:
                iview.setImageResource(R.drawable.scissors);
                break;
            default:
                break;
        }
    }
}
