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
before () : (call(* *.view(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 56/*view*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 56/*view*/);
}
}
before () : (call(* *.login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 52/*login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 52/*login*/);
}
}
before () : (call(* *.logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_market_alert_um_web0.lock){

_cls_market_alert_um_web0 _cls_inst = _cls_market_alert_um_web0._get_cls_market_alert_um_web0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 54/*logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 54/*logout*/);
}
}
}