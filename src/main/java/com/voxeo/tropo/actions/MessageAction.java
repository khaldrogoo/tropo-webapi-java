package com.voxeo.tropo.actions;

import static com.voxeo.tropo.Key.VALUE;
import support.ActionSupportHandler;

import com.voxeo.tropo.Key;
import com.voxeo.tropo.TropoException;
import com.voxeo.tropo.annotations.RequiredKeys;
import com.voxeo.tropo.annotations.ValidKeys;

@ValidKeys(keys={"say","to","answerOnMedia","channel","from","name","network","required","timeout","voice","promptLogSecurity"})
@RequiredKeys(keys={"to","say"})
public class MessageAction extends JsonAction {

	private ActionSupportHandler<SayAction> sayActionSupportHandler = new ActionSupportHandler<SayAction>(SayAction.class);	

	public MessageAction() {
		
		super();
		setName("message");
	}
	
	public MessageAction(Key... keys) {
	
		super(keys);
		setName("message");
	}
	
	public static class Say {

    public Say(String value) {

      if (value == null || value.trim().equals("")) {
        throw new TropoException("Missing required property: value of message.say");
      }

      this.value = value;
    }

    public Say(String value, String[] medias) {

      if (value == null || value.trim().equals("")) {
        throw new TropoException("Missing required property: value of message.say");
      }

      this.value = value;
      this.media = medias;
    }

    private String value;
    private String[] media;

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String[] getMedia() {
      return media;
    }

    public void setMedia(String[] media) {
      this.media = media;
    }

	}
	
	public SayAction say(String text) {

		return say(VALUE(text));
	}
	
	public SayAction say(Key... keys) {

		return sayActionSupportHandler.build(this, keys);
	}
}
