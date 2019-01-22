package presentation;

import android.app.Application;


public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        configureDagger();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private void configureDagger(){
        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

}
