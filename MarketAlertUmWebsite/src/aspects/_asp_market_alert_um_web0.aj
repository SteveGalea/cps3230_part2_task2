package aspects;

import larva.*;
public aspect _asp_market_alert_um_web0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_market_alert_um_web0.initialize();
}
}
before () : (call(* *.UserValidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*UserValidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*UserValidLogin*/);
}
}
before () : (call(* *.UserLoggedOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 14/*UserLoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 14/*UserLoggedOut*/);
}
}
before () : (call(* *.UserViewingAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 16/*UserViewingAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 16/*UserViewingAlerts*/);
}
}
}