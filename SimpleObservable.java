package com.rt.rx;

import rx.Observer;

public class SimpleObservable implements Observer<Shapes> {

	public void onCompleted() {
		System.out.println("completed...");
	}

	public void onError(Throwable arg0) {
		arg0.printStackTrace();
	}

	public void onNext(String str) {
		System.out.println(str);
	}

	public void onNext(Shapes shapes) {
		//if(shapes.name == "circle") 
			//throw new RuntimeException("I don't like circles");
		System.out.println(shapes);
	}

}
