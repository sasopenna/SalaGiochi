package pwm.penna.salagiochi.form.dto.base;


public abstract class BaseForm<K> {

    public abstract K getKey();

    public abstract void setKey(K key);

    public String getName() {
        String attributeName = this.getClass().getSimpleName();
        return Character.toLowerCase(attributeName.charAt(0)) + attributeName.substring(1);
    }
}