package com.mehdi.projet.Service;

public class ConversionData {

    private Long id;
    private String typeConversion;
    private double valeurOriginale;
    private double valeurConvertie;
    private String unite;

    public ConversionData(Long id, String typeConversion, double valeurOriginale, double valeurConvertie, String unite) {
        this.id = id;
        this.typeConversion = typeConversion;
        this.valeurOriginale = valeurOriginale;
        this.valeurConvertie = valeurConvertie;
        this.unite = unite;
    }

    public ConversionData() {

    }

    public String getTypeConversion() {
        return typeConversion;
    }

    public void setTypeConversion(String typeConversion) {
        this.typeConversion = typeConversion;
    }

    public double getValeurOriginale() {
        return valeurOriginale;
    }

    public void setValeurOriginale(double valeurOriginale) {
        this.valeurOriginale = valeurOriginale;
    }

    public double getValeurConvertie() {
        return valeurConvertie;
    }

    public void setValeurConvertie(double valeurConvertie) {
        this.valeurConvertie = valeurConvertie;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
