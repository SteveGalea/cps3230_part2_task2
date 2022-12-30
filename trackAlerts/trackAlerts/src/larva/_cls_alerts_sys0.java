package larva;


import main.*;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_alerts_sys0 implements _callable{

public static PrintWriter pw; 
public static _cls_alerts_sys0 root;

public static LinkedHashMap<_cls_alerts_sys0,_cls_alerts_sys0> _cls_alerts_sys0_instances = new LinkedHashMap<_cls_alerts_sys0,_cls_alerts_sys0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\steve\\workspace\\luna\\trackAlerts/src/output_alerts_sys.txt");

root = new _cls_alerts_sys0();
_cls_alerts_sys0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_alerts_sys0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int noOfAlerts =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_alerts_sys0() {
}

public void initialisation() {
}

public static _cls_alerts_sys0 _get_cls_alerts_sys0_inst() { synchronized(_cls_alerts_sys0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_alerts_sys0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_alerts_sys0_instances){
_performLogic_alertEventSystemProp(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_alerts_sys0[] a = new _cls_alerts_sys0[1];
synchronized(_cls_alerts_sys0_instances){
a = _cls_alerts_sys0_instances.keySet().toArray(a);}
for (_cls_alerts_sys0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_alerts_sys0_instances){
_cls_alerts_sys0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alertEventSystemProp = 19;

public void _performLogic_alertEventSystemProp(String _info, int... _event) {

_cls_alerts_sys0.pw.println("[alertEventSystemProp]AUTOMATON::> alertEventSystemProp("+") STATE::>"+ _string_alertEventSystemProp(_state_id_alertEventSystemProp, 0));
_cls_alerts_sys0.pw.flush();

if (0==1){}
else if (_state_id_alertEventSystemProp==19){
		if (1==0){}
		else if ((_occurredEvent(_event,18/*AlertCreated*/)) && (noOfAlerts ==5 )){
		noOfAlerts ++;

		_state_id_alertEventSystemProp = 18;//moving to state viewingLatestAlerts
		_goto_alertEventSystemProp(_info);
		}
		else if ((_occurredEvent(_event,18/*AlertCreated*/))){
		noOfAlerts ++;

		_state_id_alertEventSystemProp = 19;//moving to state viewingAlerts
		_goto_alertEventSystemProp(_info);
		}
		else if ((_occurredEvent(_event,20/*AlertsDeleted*/))){
		noOfAlerts =0 ;

		_state_id_alertEventSystemProp = 19;//moving to state viewingAlerts
		_goto_alertEventSystemProp(_info);
		}
}
else if (_state_id_alertEventSystemProp==18){
		if (1==0){}
		else if ((_occurredEvent(_event,18/*AlertCreated*/))){
		noOfAlerts ++;
_cls_alerts_sys0.pw .println ("Bad State: Too many alerts(alerts > 5)");

		_state_id_alertEventSystemProp = 18;//moving to state viewingLatestAlerts
		_goto_alertEventSystemProp(_info);
		}
		else if ((_occurredEvent(_event,20/*AlertsDeleted*/))){
		noOfAlerts =0 ;

		_state_id_alertEventSystemProp = 19;//moving to state viewingAlerts
		_goto_alertEventSystemProp(_info);
		}
}
}

public void _goto_alertEventSystemProp(String _info){
_cls_alerts_sys0.pw.println("[alertEventSystemProp]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alertEventSystemProp(_state_id_alertEventSystemProp, 1));
_cls_alerts_sys0.pw.flush();
}

public String _string_alertEventSystemProp(int _state_id, int _mode){
switch(_state_id){
case 19: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 18: if (_mode == 0) return "viewingLatestAlerts"; else return "!!!SYSTEM REACHED BAD STATE!!! viewingLatestAlerts "+new _BadStateExceptionalerts_sys().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}