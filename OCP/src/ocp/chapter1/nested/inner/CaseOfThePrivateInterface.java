package ocp.chapter1.nested.inner;

/**
 * Created by stefanangelov on 10/26/16.
 */
public class CaseOfThePrivateInterface {
    private interface  Secret{
        public void shh();
    }

    class DontTell implements Secret{
        public void shh(){}
    }
}
