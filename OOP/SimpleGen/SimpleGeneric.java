
package lab11.dar.pkg2105799;

public class SimpleGeneric <T> {
    
    private T objReff;
    
    SimpleGeneric (){
    
}
    
    SimpleGeneric (T object){
    objReff =object;
}
    public T getObjReff(){
        return objReff;
    }
    
    public void setObjReff(T object){
        objReff = object;
    }
    
    public void print(){
        System.out.println(objReff);
    }
    
     public void printType(){
        System.out.println(objReff.getClass().getName());
     }
}
