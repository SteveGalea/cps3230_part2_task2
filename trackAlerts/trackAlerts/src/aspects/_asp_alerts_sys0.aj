package aspects;

import main.*;

import larva.*;
public aspect _asp_alerts_sys0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_alerts_sys0.initialize();
}
}
before () : (call(* *.AlertsDeleted(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts_sys0.lock){

_cls_alerts_sys0 _cls_inst = _cls_alerts_sys0._get_cls_alerts_sys0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*AlertsDeleted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*AlertsDeleted*/);
}
}
before () : (call(* *.AlertCreated(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_alerts_sys0.lock){

_cls_alerts_sys0 _cls_inst = _cls_alerts_sys0._get_cls_alerts_sys0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 18/*AlertCreated*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 18/*AlertCreated*/);
}
}
}