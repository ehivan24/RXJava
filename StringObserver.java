package com.rt.rx;

import rx.Observer;

public class StringObserver implements Observer<String>{

	public void onCompleted() {
		
	}

	public void onError(Throwable arg0) {
		arg0.printStackTrace();
	}

	public void onNext(String arg0) {
		System.out.println(arg0);
	}

}
