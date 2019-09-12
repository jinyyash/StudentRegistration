package com.hsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

import java.util.concurrent.Executors;

@SpringBootApplication
public class TcpServerApplication implements WrapperListener {

	public static void main(String[] args) {
		WrapperManager.start(new TcpServerApplication(),args);

	}

	@Override
	public Integer start(final String[] strings) {
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {

				SpringApplication.run(TcpServerApplication.class, strings);

			}
		});
		return null;	}

	@Override
	public int stop(int i) {
		return 0;
	}

	@Override
	public void controlEvent(int i) {

	}
}
