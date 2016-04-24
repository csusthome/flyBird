package csust.anla.flybird;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicServer extends Service {

	private MediaPlayer mediaPlayer;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);

		if (mediaPlayer == null) {

			// R.raw.mmp����Դ�ļ���MP3��ʽ��
			mediaPlayer = MediaPlayer.create(this, R.raw.paopao);
			mediaPlayer.setLooping(true);
			mediaPlayer.start();

		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mediaPlayer.stop();
	}
}
