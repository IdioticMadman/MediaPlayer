package com.robert.webrtc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String VIDEO_TRACK_ID = "video";
    private static final String AUDIO_TRACK_ID = "audio";
    private static final String LOCAL_MEDIA_STREAM_ID = "local_media_stream_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /**
         * context
         * Simply the ApplicationContext, or any other Context relevant, as you are used to passing around.
         * initializeAudio
         * A boolean for initializing the audio portions.
         * initializeVideo
         * A boolean for initializing the video portions . Skipping either one of these two allows you to skip asking for permissions for this API as well, for example for DataChannel applications.
         * videoCodecHwAcceleration
         * A boolean for enabling hardware acceleration.
         * renderEGLContext
         * Can be provided to support HW video decoding to texture and will be used to create a shared EGL context on video decoding thread. This can be null - in this case HW video decoder will generate yuv420 frames instead of texture frames.
         *//*
        PeerConnectionFactory.
        boolean b = PeerConnectionFactory.initializeAndroidGlobals(this, true, true, true);
        Log.e(TAG, "PeerConnectionFactory.initializeAndroidGlobals + b: " + b);
        if (!b) {
            boolean c = PeerConnectionFactory.initializeAndroidGlobals(this, true, true, false);
            Log.e(TAG, "PeerConnectionFactory.initializeAndroidGlobals + c: " + c);
            if (!c) {
                boolean d = PeerConnectionFactory.initializeAndroidGlobals(this, true, false, false);
                Log.e(TAG, "PeerConnectionFactory.initializeAndroidGlobals + d: " + d);
            }
        }
        final PeerConnectionFactory peerConnectionFactory = new PeerConnectionFactory();

        int deviceCount = VideoCapturerAndroid.getDeviceCount();
        Log.e(TAG, "deviceCount: " + deviceCount);
        String[] deviceNames = VideoCapturerAndroid.getDeviceNames();
        for (String deviceName : deviceNames) {
            Log.e(TAG, "deviceName: " + deviceName);
        }
        String nameOfBackFacingDevice = VideoCapturerAndroid.getNameOfBackFacingDevice();
        Log.e(TAG, "nameOfBackFacingDevice: " + nameOfBackFacingDevice);
        String nameOfFrontFacingDevice = VideoCapturerAndroid.getNameOfFrontFacingDevice();
        Log.e(TAG, "nameOfFrontFacingDevice: " + nameOfFrontFacingDevice);
        VideoCapturerAndroid videoCapturerAndroid = VideoCapturerAndroid.create(nameOfFrontFacingDevice);


        MediaConstraints videoConstraints = new MediaConstraints();
        MediaConstraints audioConstraints = new MediaConstraints();
        //创建videoSource
        VideoSource videoSource = peerConnectionFactory.createVideoSource(videoCapturerAndroid, videoConstraints);

        //创建VideoTrack
        final VideoTrack videoTrack = peerConnectionFactory.createVideoTrack(VIDEO_TRACK_ID, videoSource);

        AudioSource audioSource = peerConnectionFactory.createAudioSource(audioConstraints);

        final AudioTrack audioTrack = peerConnectionFactory.createAudioTrack(AUDIO_TRACK_ID, audioSource);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                VideoRenderer renderer = null;
                try {
                    Log.e(TAG, "run: 1");
                    renderer = VideoRendererGui.createGui(0, 0, 100, 100, VideoRendererGui.ScalingType.SCALE_FILL, false);
                } catch (Exception e) {
                    Log.e(TAG, "run: 2");
                    e.printStackTrace();
                }
                Log.e(TAG, "run: 3");
                if (renderer != null) {
                    videoTrack.addRenderer(renderer);
                    MediaStream mediaStream = peerConnectionFactory.createLocalMediaStream(LOCAL_MEDIA_STREAM_ID);
                    mediaStream.addTrack(audioTrack);
                    mediaStream.addTrack(videoTrack);
                    Log.e(TAG, "run: 4");
                }
            }
        };
        VideoRendererGui.setView(glSurfaceView, runnable);*/

    }
}
