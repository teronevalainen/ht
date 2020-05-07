package com.example.ht;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView eventName;
    TextView eventTime;
    TextView eventAge;
    TextView eventPlace;
    TextView eventDate;
    static User user;
    Intent intent;

    Context context;
    EventList events;
    Button giveFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        eventName = (TextView) findViewById(R.id.ename);
        eventTime = (TextView) findViewById(R.id.estart);
        eventAge= (TextView) findViewById(R.id.eage);
        eventPlace = (TextView) findViewById(R.id.eplace);
        eventDate= (TextView) findViewById(R.id.edate);

        context = this.getApplicationContext();
        giveFeedback = (Button) findViewById(R.id.feedb);
        giveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFeedback();
            }
        });

        intent = getIntent();
        if ((intent.getStringExtra("acc"))!=null) {               //Määrittelee käyttäjän
            String username = intent.getStringExtra("acc");
            if (username.equals("Admin")) {
                user = new Admin();
            }  else if (username.equals("Guest")) {
                user = new Guest();
            } else {
                user = new Employee(username);          //peruskäyttäjän tilin nimen kanssa kikkailua -
            }                                           //- käytetään userSettingsseissä
        }
        System.out.println("toimiiko2");


        events = EventList.getInstance();
        XmlReadWrite xml = new XmlReadWrite();              //Tiedostoon kirjoitukset ja luku
        xml.writeXML(context);
        if (!(events.getInstance().getEvents().isEmpty())) {
            xml.readXML(context);
        }
        eventName.setText(events.getEvent(0).getName());
        eventTime.setText(events.getEvent(0).getStart() + " - " + events.getEvent(0).getEnd() + " aikavälillä");
        eventAge.setText(events.getEvent(0).getAge() + "v ikäisille");
        eventPlace.setText(events.getEvent(0).getPlace() + " nuorisotalolla");
        eventDate.setText(events.getEvent(0).getDate());
    }

    public void startEvent() {  //aloittaa tapahtumat
        intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    public void startFeedback() {   //Palautteen antaminen
        intent = new Intent(this, FeedbackActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //Antaa eri oikeudet eri käyttäjille -
        if (user.username.equals("Guest")) {                //lisäämällä menu valikkoon lisätoimintoja
            //Ei oikeuksia guestille
        }
        else if (user.username.equals("Admin")) {   //Adminilla kaikki oikeudet
            menu.add(0, 1, Menu.NONE, "Tapahtumat");
            menu.add(0,2,Menu.NONE,"Käyttäjä asetukset");
            menu.add(0, 3, Menu.NONE, "Adminin toiminto");
        }
        else  {   //Työskentelijällä oikeus tapahtumien muokkaukseen ja käyttjäasetuksiin
            menu.add(0, 1, Menu.NONE,"Tapahtumat");
            menu.add(0,2,Menu.NONE,"Käyttäjä asetukset");
        }
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item:
                intent = new Intent(this, LoginActivity.class); //Kirjautuminen ulos
                startActivity(intent);
                return true;
            case 1:
                startEvent();           //Avaa tapahtumat
                break;
            case 2:
                intent = new Intent(this, UserSettings.class);  //Käyttäjä asetukset
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
