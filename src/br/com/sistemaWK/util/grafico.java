package br.com.sistemaWK.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.sistemaWK.facade.VendasFacade;
import br.com.sistemaWK.model.Vendas;


@Named
@ViewScoped
public class grafico implements Serializable {

	
	 /**
    *
    */
   private static final long serialVersionUID = 1L;
   private BarChartModel animatedModel2;
   private Integer nVendasJaneiros;
   private Date dataInicial;
   private Date dataFinal;
   private Integer diaInicio;
   private Integer diaFinal;
   private Date dataTerceiroDia;
   private Date dataQuartoDia;
   private Date dataQuintoDia;
   private Float saldoPrimeiroDia = 0f;
   private Float saldoSegundoDia = 0f;
   private Float saldoTerceiroDia = 0f;
   private Float saldoQuartoDia = 0f;
   private Float saldoQuintaDia = 0f;
   private Integer numeroDia;
   private Float valorMaximo = 0f;
   private Float valorMinimo = 0f;
   private Float valorFaturamento = 0f;
   private String valorTotalFaturamento = "";
   @Inject
   private UsuarioLogadoMB usuarioLogadoMB;
   private String ano = "" + Formatacao.getAnoData(new Date());
   private int nVendasGrafico = 0;

   @PostConstruct
   public void init() {
       createAnimatedModels();
       valorTotalFaturamento = Formatacao.foramtarFloatString(valorFaturamento);
   }

   public UsuarioLogadoMB getUsuarioLogadoMB() {
       return usuarioLogadoMB;
   }

   public void setUsuarioLogadoMB(UsuarioLogadoMB usuarioLogadoMB) {
       this.usuarioLogadoMB = usuarioLogadoMB;
   }

   public String getValorTotalFaturamento() {
       return valorTotalFaturamento;
   }

   public void setValorTotalFaturamento(String valorTotalFaturamento) {
       this.valorTotalFaturamento = valorTotalFaturamento;
   }

   public Float getValorFaturamento() {
       return valorFaturamento;
   }

   public void setValorFaturamento(Float valorFaturamento) {
       this.valorFaturamento = valorFaturamento;
   }

   public void setAnimatedModel2(BarChartModel animatedModel2) {
       this.animatedModel2 = animatedModel2;
   }

   public Float getValorMaximo() {
       return valorMaximo;
   }

   public void setValorMaximo(Float valorMaximo) {
       this.valorMaximo = valorMaximo;
   }

   public Float getValorMinimo() {
       return valorMinimo;
   }

   public void setValorMinimo(Float valorMinimo) {
       this.valorMinimo = valorMinimo;
   }

   public Integer getNumeroDia() {
       return numeroDia;
   }

   public void setNumeroDia(Integer numeroDia) {
       this.numeroDia = numeroDia;
   }

   public Float getSaldoPrimeiroDia() {
       return saldoPrimeiroDia;
   }

   public void setSaldoPrimeiroDia(Float saldoPrimeiroDia) {
       this.saldoPrimeiroDia = saldoPrimeiroDia;
   }

   public Float getSaldoSegundoDia() {
       return saldoSegundoDia;
   }

   public void setSaldoSegundoDia(Float saldoSegundoDia) {
       this.saldoSegundoDia = saldoSegundoDia;
   }

   public Float getSaldoTerceiroDia() {
       return saldoTerceiroDia;
   }

   public void setSaldoTerceiroDia(Float saldoTerceiroDia) {
       this.saldoTerceiroDia = saldoTerceiroDia;
   }

   public Float getSaldoQuartoDia() {
       return saldoQuartoDia;
   }

   public void setSaldoQuartoDia(Float saldoQuartoDia) {
       this.saldoQuartoDia = saldoQuartoDia;
   }

   public Float getSaldoQuintaDia() {
       return saldoQuintaDia;
   }

   public void setSaldoQuintaDia(Float saldoQuintaDia) {
       this.saldoQuintaDia = saldoQuintaDia;
   }

   public Date getDataTerceiroDia() {
       return dataTerceiroDia;
   }

   public void setDataTerceiroDia(Date dataTerceiroDia) {
       this.dataTerceiroDia = dataTerceiroDia;
   }

   public Date getDataQuartoDia() {
       return dataQuartoDia;
   }

   public void setDataQuartoDia(Date dataQuartoDia) {
       this.dataQuartoDia = dataQuartoDia;
   }

   public Date getDataQuintoDia() {
       return dataQuintoDia;
   }

   public void setDataQuintoDia(Date dataQuintoDia) {
       this.dataQuintoDia = dataQuintoDia;
   }

   public Integer getDiaInicio() {
       return diaInicio;
   }

   public void setDiaInicio(Integer diaInicio) {
       this.diaInicio = diaInicio;
   }

   public Integer getDiaFinal() {
       return diaFinal;
   }

   public void setDiaFinal(Integer diaFinal) {
       this.diaFinal = diaFinal;
   }

   public Date getDataInicial() {
       return dataInicial;
   }

   public void setDataInicial(Date dataInicial) {
       this.dataInicial = dataInicial;
   }

   public Date getDataFinal() {
       return dataFinal;
   }

   public void setDataFinal(Date dataFinal) {
       this.dataFinal = dataFinal;
   }

   public Integer getnVendasJaneiros() {
       return nVendasJaneiros;
   }

   public void setnVendasJaneiros(Integer nVendasJaneiros) {
       this.nVendasJaneiros = nVendasJaneiros;
   }

   public BarChartModel getAnimatedModel2() {
       return animatedModel2;
   }

   public String getAno() {
       return ano;
   }

   public void setAno(String ano) {
       this.ano = ano;
   }

   public int getnVendasGrafico() {
       return nVendasGrafico;
   }

   public void setnVendasGrafico(int nVendasGrafico) {
       this.nVendasGrafico = nVendasGrafico;
   }

   private void createAnimatedModels() {
       animatedModel2 = initBarModel();
       animatedModel2.setSeriesColors("145B7A");
       animatedModel2.setAnimate(true);
       Axis yAxis = animatedModel2.getAxis(AxisType.Y);
       yAxis.setMin(0);
       yAxis.setMax(nVendasGrafico + 200);

   }

   private BarChartModel initBarModel() {
       BarChartModel model = new BarChartModel();
       ChartSeries mes = new ChartSeries();
       mes.setLabel("Quantidade");

       mes.set("JAN", gerarVendasMensaisJaneiro());
       mes.set("FEV", gerarVendasMensaisFevereiro());
       mes.set("MAR", gerarVendasMensaisMarco());
       mes.set("ABRI", gerarVendasMensaisAbril());
       mes.set("MAI", gerarVendasMensaisMaio());
       mes.set("JUN", gerarVendasMensaisJunho());
       mes.set("JUL", gerarVendasMensaisJulho());
       mes.set("AGO", gerarVendasMensaisAgosto());
       mes.set("SET", gerarVendasMensaisSetembro());
       mes.set("OUT", gerarVendasMensaisOutubro());
       mes.set("NOV", gerarVendasMensaisNovembro());
       mes.set("DEZ", gerarVendasMensaisDezembro());
       model.addSeries(mes);

       return model;
   }

   public Integer gerarNumeroDia(Integer dia, Integer mes) {
       if (mes == 1) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 2) {
           if (dia > 28) {
               dia = 1;
           }
       } else if (mes == 3) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 4) {
           if (dia > 30) {
               dia = 1;
           }
       } else if (mes == 5) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 6) {
           if (dia > 30) {
               dia = 1;
           }
       } else if (mes == 7) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 8) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 9) {
           if (dia > 30) {
               return null;
           }
       } else if (mes == 10) {
           if (dia > 31) {
               dia = 1;
           }
       } else if (mes == 11) {
           if (dia > 30) {
               dia = 1;
           }
       } else if (mes == 12) {
           if (dia > 31) {
               dia = 1;
           }
       }
       return dia;
   }

   public Integer gerarVendasMensaisJaneiro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-01-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-01-31'";
      List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisFevereiro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-02-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-02-28'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisMarco() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-03-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-03-31'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisAbril() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-04-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-04-30'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisMaio() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-05-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-05-31'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisJunho() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-06-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-06-30'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisJulho() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-07-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-07-31'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisAgosto() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-08-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-08-31'";
      List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisSetembro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-09-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-09-30'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisOutubro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-10-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-10-31'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisNovembro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-11-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-11-30'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }

   public Integer gerarVendasMensaisDezembro() {
	   VendasFacade vendasFacade = new VendasFacade();
       String sql = "select v from Vendas v where v.datavenda>='" + Formatacao.getAnoData(new Date()) + "-12-01'"
               + " and v.datavenda<='" + Formatacao.getAnoData(new Date()) + "-12-31'";
       List<Vendas> listaQuantidadeVendas = vendasFacade.listar(sql);
       for (int i = 0; i < listaQuantidadeVendas.size(); i++) {
           valorFaturamento = valorFaturamento + listaQuantidadeVendas.get(i).getValorvenda();
       }
       if (nVendasGrafico < listaQuantidadeVendas.size()) {
           nVendasGrafico = listaQuantidadeVendas.size();
       }
       return listaQuantidadeVendas.size();
   }
}
