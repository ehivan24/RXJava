package com.rt.rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.functions.Func2;

/**
 * Reactive Java
 *
 */
public class App {
	
	private final static int COUNT_END = 6;
	private final static int COUNT_START = 3;
	private final static int COUNT_TAKE = 10;
	
    public static void main( String[] args ){
        
    	selectPersonFromList("M", "l", COUNT_TAKE);
    	
    	    	
    }
    
    public static void sendHttpRequests(){

    	
    	
    }
    
    public static void selectPersonFromList(String prefix, String ends, int count){
    	List<String> lists = new ArrayList<String>();
    	lists.add("Joe");
    	lists.add("Marcus");
    	lists.add("April");
    	lists.add("Miguel");
    	lists.add("Mary");
    	
    	Observable<String> obs = Observable.from(lists)
    			.filter(v -> v.startsWith(prefix))
    			.filter(c -> c.endsWith(ends));
    			
    			
    	Observable<String> obs2 = obs.take(count);
    	
    	obs2.subscribe(
    					args-> System.out.println(args)
    				);
    }
    
    public static void obsZip(){
    	Observable<Integer> obs1 = Observable.from(Arrays.asList(2,12,34,6,71, 67));
    	Observable<Integer> obs2 = Observable.from(Arrays.asList(45,6,8,23,13));
    	
    	Observable<List<Integer>> obser = Observable.zip( obs1, obs2, new Func2<Integer, Integer, List<Integer>>() {

			@Override
			public List<Integer> call(Integer val1, Integer val2) {
				List<Integer> list = new ArrayList<>();
				list.add(val1);
				list.add(val2);
				
				return list;
			}
    	});
    	obser.subscribe(new IntegerObservable());
    	
    }
    
    public static void obsStr(){
    	Observable
    	.just("The","invisible","man","took","over")
    	.take(2) // 
    	.skip(1)
    	.subscribe(new StringObserver());
    }
    
    public static void obsNums() {
    	Observable
    	.range(COUNT_START, COUNT_END)
    	.map(integer -> {
    		System.out.println("Map: (" + Thread.currentThread().getName() + ")");
            return integer + 2;
    	
    	})
    	.subscribe(integer -> 
    		System.out.println("Got: " + integer + " (" + Thread.currentThread().getName() + ")")
        );
    }
    
    public static void obsTest() {
    	Shapes shapes = new Shapes();
    	
    	List<Shapes> shapeList = new ArrayList<>();
    	shapeList.add(new Shapes("rectangle", 4));
    	shapeList.add(new Shapes("circle"));
    	shapeList.add(new Shapes("square",4 ));
    	shapeList.add(new Shapes("triangle", 3));
    	
    	List<Product> listProduct = new ArrayList<>();
    	listProduct.add(new Product("Coffee cup", 12));
    	listProduct.add(new Product("Tea cup", 21));
    	listProduct.add(new Product("Plate", 9));
    	listProduct.add(new Product("Chair", 43));
    	
    			
    	Observable<Shapes> observableString = Observable.from(shapeList);
    	observableString.subscribe(new SimpleObservable());
    	
    	Observable<Shapes> onShapes = Observable.from(shapeList);
    	onShapes.take(COUNT_END);
    	onShapes.subscribe(new SimpleObservable());
	}
}
