package com.example.peacefull_dessert_mob_dev;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class AppMusic extends Service {
    private static final String TAG = "AppMusic";
    private static final String CHANNEL_ID = "appMusicChannel";
    private MediaPlayer mediaPlayer;
    public static boolean isPlaying = false;
    public AppMusic() {
        // Blank constructor class
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "App Music Service created");
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "App Music Service started");

        // Dont start if a sound service is already playing
        if (isPlaying) {
            Log.d(TAG, "App Music is already playing");
            return START_STICKY;
        }

        Intent notificationIntent = new Intent(this, LogInActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                10, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        // Persistant Notification build
        Notification notif = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("App Music Playing")
                .setContentText("Foreground service is active")
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentIntent(pendingIntent)// Set the intent for when the user taps the notification
                .build();
        startForeground(1001, notif);

        mediaPlayer = MediaPlayer.create(this, R.raw.undertalehome);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        isPlaying = true;

        Log.d(TAG, "App Music started.");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "App Music Service destroyed");
        stopForeground(true);

        // if the media player isnt null stop it then release it
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        // Sets isPlaying to false as service is destroyed
        isPlaying = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void createNotificationChannel() {
        // Notification channel
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "App Music",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Shows when foreground app Music service is running");

        NotificationManager manager = getSystemService(NotificationManager.class);

        manager.createNotificationChannel(channel);
    }
}




