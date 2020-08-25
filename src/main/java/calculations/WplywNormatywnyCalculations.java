package calculations;

public class WplywNormatywnyCalculations {

    public double calculateWholeWplywNormatywny (int umywalkaQuantity, int zlewozmywakQuantity, int wannaQuantity,int natryskQuantity,
                                                 int pralkaQuantity, int zmywarkaQuantity, int pisuarQuantity,int pluczkaZbiornikowQuantity){

        return calculateUmywalka(umywalkaQuantity) + calculateZlewozmywak( zlewozmywakQuantity) + calculateWanna(wannaQuantity)
                   + calculateNatrysk(natryskQuantity) +calculatePralka(pralkaQuantity) + calculateZmywarka( zmywarkaQuantity)
                   + calculatePisuar(pisuarQuantity) +calculatePluczkaZbiornikowa(pluczkaZbiornikowQuantity);
    }

    private double calculateUmywalka(int quantity){
            return quantity * 0.07;
    }
    private double calculateZlewozmywak(int quantity){
        return quantity * 0.07;
    }
    private double calculateWanna(int quantity){
        return quantity * 0.15;
    }
    private double calculateNatrysk(int quantity){
        return quantity * 0.15;
    }
    private double calculatePralka(int quantity){
        return quantity * 0.25;
    }
    private double calculateZmywarka(int quantity){
        return quantity * 0.15;
    }
    private double calculatePisuar(int quantity){
        return quantity * 0.30;
    }
    private double calculatePluczkaZbiornikowa(int quantity){
        return quantity * 0.13;
    }
}
