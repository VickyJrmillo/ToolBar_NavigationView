package com.example.sala305_pc_03.toolbar;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener,Fragment3.OnFragmentInteractionListener{


    //Creacion de la variable privada ----------------------
    private DrawerLayout drawerLayout;
    private NavigationView navView;



//FIN Creacion de la variable privada ----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      //ToolBar propio --------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //FIN ToolBar propio --------------------------------------------------------------


        //Llamar al menu2 llamar al icono del menu
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.opciones_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        //LLAMAR AL FRAGMENTO
        navView = (NavigationView)findViewById(R.id.navview);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                fragment = new Fragment1();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_2:
                                fragment = new Fragment2();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_3:
                                fragment = new Fragment3();
                                fragmentTransaction = true;
                                break;
                        }
                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();
                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
        //FIN LLAMAR FRAGMENTO

    }


    //LLAMAR LOS ICONOS DEL MENU --------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1 , menu);
        return true;}
    //FIN LLAMAR LOS ICONOS DEL MENU --------------------------------------------------



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Nuevo:

                Toast.makeText( getApplicationContext(),"Click sobre el boton nuevo",Toast.LENGTH_SHORT).show();  //imprimir mensaje / menu emergente

                return true;
            case R.id.action_buscar:
                Toast.makeText(getApplicationContext(),"Click sobre el boton Buscar",Toast.LENGTH_SHORT).show(); //imprimir mensaje / menu emergente
                return true;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Click sobre el boton Settings",Toast.LENGTH_SHORT).show(); //imprimir mensaje / menu emergente
                return true;

            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickFAB(View view) {
        Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
