package com.rt.rx;

import java.util.List;

import rx.Observer;

public class IntegerObservable implements Observer<List<Integer>>{

	@Override
	public void onCompleted() {
		
	}

	@Override
	public void onError(Throwable arg0) {
		
	}

	@Override
	public void onNext(List<Integer> arg0) {
		System.out.println(arg0);
	}

}
