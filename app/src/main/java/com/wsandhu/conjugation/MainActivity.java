package com.wsandhu.conjugation;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wsandhu.inappbilling.IabHelper;
import com.wsandhu.inappbilling.IabResult;
import com.wsandhu.inappbilling.Inventory;
import com.wsandhu.inappbilling.Purchase;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = "com.wsandhu.inappbilling";
    static final String ITEM_SKU = "com.wsandhu.conjugation.removeads";
    static IabHelper mHelper;

    Toolbar toolbar;

    ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    boolean check = false;
    boolean adFree;
    boolean tabletSize;

    public static SharedPreferences prefs;

    @Override
    protected void onStart() {
        super.onStart();

        // Monitor launch times and interval from installation
        AppRater.onStart(this);

        // If the criteria is satisfied, "Rate this app" dialog will be shown
        AppRater.showRateDialogIfNeeded(this);

        queryPurchasedItems();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tabs setup
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container1, new TabBarFragment())
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new OtherFragment())
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new PerfectFragment())
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();

        // For multitasking card view
        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setTaskDescription(new ActivityManager.TaskDescription("Conjugate Spanish Verbs", icon, getResources().getColor(R.color.primaryColorDark)));
        }

        // FOR NAVIGATION VIEW ITEM TEXT COLOR
        int[][] state = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] color = new int[] {
                Color.DKGRAY,
                Color.DKGRAY,
                Color.DKGRAY,
                Color.DKGRAY
        };

        ColorStateList csl = new ColorStateList(state, color);

        // FOR NAVIGATION VIEW ITEM ICON COLOR
        int[][] states = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] colors = new int[] {
                getResources().getColor(R.color.primaryColorDark),
                getResources().getColor(R.color.primaryColorDark),
                getResources().getColor(R.color.primaryColorDark),
                getResources().getColor(R.color.primaryColorDark),
        };

        ColorStateList csl2 = new ColorStateList(states, colors);

        // Status bar color for Lollipop
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.primaryColor));

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.primaryColorDark));
        }

        // Toolbar setup
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Navigation drawer setup
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemTextColor(csl);
        navigationView.setItemIconTintList(csl2);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger onItemClick of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                // Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked())
                    menuItem.setChecked(false);
                else menuItem.setChecked(true);

                // Closing drawer on item click
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.conjugate:
                        if (check = true && getSupportFragmentManager().findFragmentById(R.id.container2) != null) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .remove(getSupportFragmentManager().findFragmentById(R.id.container2))
                                    .commit();
                            check = false;
                        } else if (check = false) {
                           drawerLayout.closeDrawers();
                        }
                        return true;
                    case R.id.learn:
                        check = true;
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container2, new LearnFragment())
                                .commit();
                        return true;
                }
                return true;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        // Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(drawerToggle);

        // calling sync state is necessary or else your hamburger icon wont show up
        drawerToggle.syncState();

        // For in-app purchases
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAslCj011Va+mSON" +
                "KbWLHsCuvRd9cSnfskICkxXK4EB1X8AZ6q6hxRzIJVT7QTI1apiAskjVRna7RmdRcI4/v5GzcF8ugmw2WLH" +
                "1Ggz7tD/me6P/Rz8T+mc48rXkbfRlgtMxkQQK1ZQd8aoszE+3vvrRoISqcOrFrWfVHvOxsgYrDqdjtNqFjo" +
                "qPFI0S4f9CBMXgpO/YKcAuTTXTqiDlqjnJqk2xgaxj5yWhHXmV2MDkK9nqgCTdzSJ2IOBj0xC6N+cUd/qRQ" +
                "6dzU5SSbaY0txePNnaLdzqnu8KnvQwJdvJBkcJqU3jtXeyUz/4ob6HF+lYuVU3Krlns0cjNoCKt1UcwIDAQAB";

        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {

                } else {
                    mHelper.queryInventoryAsync(mReceivedInventoryListener);
                }
            }
        });

        // checking if in-app purchase has been made
        prefs = this.getSharedPreferences("com.wsandhu.conjugation", Context.MODE_PRIVATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.action_bugreport) {
            sendBugReport();
        } else if (id == R.id.remove_ads) {

            tabletSize = getResources().getBoolean(R.bool.isTablet);
            if (tabletSize) {
                new AlertDialog.Builder(this)
                        .setTitle("No need to donate!")
                        .setMessage("You're already ad-free! :)")
                        .setPositiveButton("Bueno", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            } else {
                buyFullVersion();
            }

        } else if (id == R.id.thanks) {
            sayThanks();
        }

        return super.onOptionsItemSelected(item);
    }

    private void sayThanks() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage("Awesome Spanish teachers\n" +
                        "• Señora Fennell\n" +
                        "• Señor Andrade\n" +
                        "• Señora Hernández\n" +
                        "\n" +
                        "Beta Testers\n" +
                        "• Milan Shergill\n" +
                        "• Jaskarn Heer\n" +
                        "• Pavi Randhawa\n" +
                        "• Luke Roberts\n" +
                        "• Jay Wu\n" +
                        "\n" +
                        "Open Source Libraries\n" +
                        "• MaterialTabs by neokree\n" +
                        "• android-flat-button by hoang8f\n" +
                        "\n" +
                        "Thanks to my family for helping me publish my first app ever on the Play Store. And a special thanks to the /r/Android community on reddit for helping this app take off.")
                .setPositiveButton("Bueno", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    // Bug report method, called in onOptionsItemSelected()
    private void sendBugReport() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "sandhuwasim@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Conjugation: Bug Report");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I just found a bug in your app. Here's the problem: ");
        emailIntent.setData(Uri.parse("mailto:" + "sandhuwasim@gmail.com"));
        startActivity(Intent.createChooser(emailIntent, "Send Email to Developer"));
    }

    /* FOR IN-APP BILLING */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!mHelper.handleActivityResult(requestCode,
                resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener  =
            new IabHelper.OnIabPurchaseFinishedListener() {
                public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
                    if (result.isFailure()) {
                        // Handle error
                        return;
                    } else if (purchase.getSku().equals(ITEM_SKU)) {
                        // Sets purchased boolean to true
                        prefs.edit().putBoolean("adFree", true).commit();

                        // Restart app
                        Intent i = getBaseContext().getPackageManager()
                                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                }
            };

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                Purchase purchase = inventory.getPurchase(ITEM_SKU);
                if (purchase != null || inventory.hasPurchase(ITEM_SKU)) {
                    // Sets purchased boolean to true
                    prefs.edit().putBoolean("adFree", true).commit();
                } else {

                }
            }
        }
    };

    public void buyFullVersion() {
        mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001,
                mPurchaseFinishedListener, "mypurchasetoken");
    }

    private void queryPurchasedItems() {
        //check if user has bought "remove adds"
        Log.d("IAP", "Method has been called.");
        if (mHelper.isSetupDone() && !mHelper.isAsyncInProgress()) {
            mHelper.queryInventoryAsync(mReceivedInventoryListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        queryPurchasedItems();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }
}

