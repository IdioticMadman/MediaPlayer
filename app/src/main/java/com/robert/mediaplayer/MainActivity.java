package com.robert.mediaplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView percentTv;
    private TextView netSpeedTv;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //显示缓冲百分比的TextView
        percentTv = (TextView) findViewById(R.id.buffer_percent);
        //显示下载网速的TextView
        netSpeedTv = (TextView) findViewById(R.id.net_speed);

        if (Vitamio.initialize(this)) {
            videoView = (VideoView) findViewById(R.id.vitamio);
            videoView.setVideoURI(Uri.parse("rtsp://192.168.1.109:5540/333_track201.cmp-muxed.mp4"));
//            videoView.setVideoURI(Uri.parse("rtsp://admin:yz123456@192.168.1.21:554/ISAPI/Streaming/Channels/1"));
//            videoView.setVideoURI(Uri.parse("rtsp://218.204.223.237:554/live/1/67A7572844E51A64/f68g2mj7wjua3la7.sdp"));
//            MediaController controller = new MediaController(this);
//            videoView.setMediaController(controller);
            videoView.start();
            videoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {
                    percentTv.setText("已缓冲：" + percent + "%");
                }
            });
            videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    switch (what) {
                        //开始缓冲
                        case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                            Log.e(TAG, "onInfo: MEDIA_INFO_DOWNLOAD_RATE_CHANGED");
                            if (videoView.isPlaying()) {
                                netSpeedTv.setVisibility(View.GONE);
                                percentTv.setVisibility(View.GONE);
                            } else {
                                percentTv.setVisibility(View.VISIBLE);
                                netSpeedTv.setVisibility(View.VISIBLE);
                                netSpeedTv.setText("当前网速:" + extra + "kb/s");
                            }
                            break;
                    }
                    return true;
                }
            });
        } else {
            Toast.makeText(this, "不支持", Toast.LENGTH_LONG).show();
        }
    }
}
