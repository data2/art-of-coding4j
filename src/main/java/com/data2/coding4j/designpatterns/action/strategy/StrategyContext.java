package com.data2.coding4j.designpatterns.action.strategy;
/**
 * 策略模式 优点
 * 避免使用多重条件，如果不使用策略模式，对于所有的算法，必须使用条件语句进行连接，通过条件判断来决定使用哪一种算法，但是使用多重条件判断是非常不容易维护的。
 * 
 * 策略模式 缺点
 * 维护各个策略类会给开发带来额外开销 策略类的数量超过5个，就比较令人头疼了。
 * 必须对客户端（调用者）暴露所有的策略类，因为使用哪种策略是由客户端来决定的
 */
public class StrategyContext {
	
	private Strategy strategy;
	
	public StrategyContext(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void execute() {
		strategy.doSomething();
	}

	
	
	public static void main(String[] args) {
		StrategyContext strategyContext = new StrategyContext(new StrategyA());
		strategyContext.execute();
	}

}
