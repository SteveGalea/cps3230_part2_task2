package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_market_alert_um_web0 implements _callable{

public static PrintWriter pw; 
public static _cls_market_alert_um_web0 root;

public static LinkedHashMap<_cls_market_alert_um_web0,_cls_market_alert_um_web0> _cls_market_alert_um_web0_instances = new LinkedHashMap<_cls_market_alert_um_web0,_cls_market_alert_um_web0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\steve\\workspace\\luna\\MarketAlertUmWebsite/src/output_market_alert_um_web.txt");

root = new _cls_market_alert_um_web0();
_cls_market_alert_um_web0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_market_alert_um_web0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_market_alert_um_web0() {
}

public void initialisation() {
}

public static _cls_market_alert_um_web0 _get_cls_market_alert_um_web0_inst() { synchronized(_cls_market_alert_um_web0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_market_alert_um_web0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_market_alert_um_web0_instances){
_performLogic_MarketAlertUmProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_market_alert_um_web0[] a = new _cls_market_alert_um_web0[1];
synchronized(_cls_market_alert_um_web0_instances){
a = _cls_market_alert_um_web0_instances.keySet().toArray(a);}
for (_cls_market_alert_um_web0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_market_alert_um_web0_instances){
_cls_market_alert_um_web0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_MarketAlertUmProperty = 17;

public void _performLogic_MarketAlertUmProperty(String _info, int... _event) {

_cls_market_alert_um_web0.pw.println("[MarketAlertUmProperty]AUTOMATON::> MarketAlertUmProperty("+") STATE::>"+ _string_MarketAlertUmProperty(_state_id_MarketAlertUmProperty, 0));
_cls_market_alert_um_web0.pw.flush();

if (0==1){}
else if (_state_id_MarketAlertUmProperty==14){
		if (1==0){}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: viewing alerts this way is not possible");

		_state_id_MarketAlertUmProperty = 14;//moving to state badViewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		loggedIn =true ;

		_state_id_MarketAlertUmProperty = 16;//moving to state loggedIn
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: logging out this way is not possible");

		_state_id_MarketAlertUmProperty = 13;//moving to state tooManyLogOuts
		_goto_MarketAlertUmProperty(_info);
		}
}
else if (_state_id_MarketAlertUmProperty==15){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		loggedIn =false ;

		_state_id_MarketAlertUmProperty = 17;//moving to state loggedOut
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		;

		_state_id_MarketAlertUmProperty = 15;//moving to state viewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: too many log ins");

		_state_id_MarketAlertUmProperty = 12;//moving to state tooManyLogIns
		_goto_MarketAlertUmProperty(_info);
		}
}
else if (_state_id_MarketAlertUmProperty==16){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		loggedIn =false ;

		_state_id_MarketAlertUmProperty = 17;//moving to state loggedOut
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		;

		_state_id_MarketAlertUmProperty = 15;//moving to state viewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: too many log ins");

		_state_id_MarketAlertUmProperty = 12;//moving to state tooManyLogIns
		_goto_MarketAlertUmProperty(_info);
		}
}
else if (_state_id_MarketAlertUmProperty==13){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: too many log outs");

		_state_id_MarketAlertUmProperty = 13;//moving to state tooManyLogOuts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: user not logged in to view alerts");

		_state_id_MarketAlertUmProperty = 14;//moving to state badViewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		loggedIn =true ;

		_state_id_MarketAlertUmProperty = 16;//moving to state loggedIn
		_goto_MarketAlertUmProperty(_info);
		}
}
else if (_state_id_MarketAlertUmProperty==17){
		if (1==0){}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		loggedIn =true ;

		_state_id_MarketAlertUmProperty = 16;//moving to state loggedIn
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: user not logged in to view alerts");

		_state_id_MarketAlertUmProperty = 14;//moving to state badViewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: logging out this way is not possible");

		_state_id_MarketAlertUmProperty = 13;//moving to state tooManyLogOuts
		_goto_MarketAlertUmProperty(_info);
		}
}
else if (_state_id_MarketAlertUmProperty==12){
		if (1==0){}
		else if ((_occurredEvent(_event,12/*UserValidLogin*/))){
		_cls_market_alert_um_web0.pw .println ("Bad State: too many log ins");

		_state_id_MarketAlertUmProperty = 12;//moving to state tooManyLogIns
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*UserLoggedOut*/))){
		loggedIn =false ;

		_state_id_MarketAlertUmProperty = 17;//moving to state loggedOut
		_goto_MarketAlertUmProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*UserViewingAlerts*/))){
		;

		_state_id_MarketAlertUmProperty = 15;//moving to state viewingAlerts
		_goto_MarketAlertUmProperty(_info);
		}
}
}

public void _goto_MarketAlertUmProperty(String _info){
_cls_market_alert_um_web0.pw.println("[MarketAlertUmProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_MarketAlertUmProperty(_state_id_MarketAlertUmProperty, 1));
_cls_market_alert_um_web0.pw.flush();
}

public String _string_MarketAlertUmProperty(int _state_id, int _mode){
switch(_state_id){
case 14: if (_mode == 0) return "badViewingAlerts"; else return "!!!SYSTEM REACHED BAD STATE!!! badViewingAlerts "+new _BadStateExceptionmarket_alert_um_web().toString()+" ";
case 15: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 16: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 13: if (_mode == 0) return "tooManyLogOuts"; else return "!!!SYSTEM REACHED BAD STATE!!! tooManyLogOuts "+new _BadStateExceptionmarket_alert_um_web().toString()+" ";
case 17: if (_mode == 0) return "loggedOut"; else return "loggedOut";
case 12: if (_mode == 0) return "tooManyLogIns"; else return "!!!SYSTEM REACHED BAD STATE!!! tooManyLogIns "+new _BadStateExceptionmarket_alert_um_web().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}