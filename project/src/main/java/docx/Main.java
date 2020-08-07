package docx;

import org.apache.commons.compress.utils.IOUtils;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;

public class Main {

    private static void addBorders(Tbl table) {
        table.setTblPr(new TblPr());// 必须设置一个TblPr，否则最后会报空指针异常

        CTBorder border = new CTBorder();
        border.setColor("auto");
        border.setSz(new BigInteger("4"));
        border.setSpace(new BigInteger("0"));
        border.setVal(STBorder.SINGLE);

        TblBorders borders = new TblBorders();
        borders.setBottom(border);
        borders.setLeft(border);
        borders.setRight(border);
        borders.setTop(border);
        borders.setInsideH(border);
        borders.setInsideV(border);

        // 获取其内部的TblPr属性设置属性
        table.getTblPr().setTblBorders(borders);
    }


    public static void main(String[] args) throws Exception {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");


        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        ObjectFactory factory = Context.getWmlObjectFactory();
        Tbl table = factory.createTbl();
        addBorders(table);



        for (int i = 0; i < 3; i++) {
            Tr tr = factory.createTr();
            for (int j = 0; j < 3; j++) {
                Tc tc = factory.createTc();
                //P p = mainDocumentPart.createParagraphOfText("---row" + i + "---column" + j + "---" + "测试");
                //p.setPPr(ppr);

                RPr rpr = factory.createRPr();

                RFonts font = new RFonts();
                //设置字体
                font.setAscii("宋体");
                font.setEastAsia("宋体");//经测试发现这个设置生效
                rpr.setRFonts(font);
                //设置颜色
                Color color = new Color();
                color.setVal("ABCDEF");
                rpr.setColor(color);
                //设置字体大小
                HpsMeasure fontSize = new HpsMeasure();
                fontSize.setVal(new BigInteger("48"));
                rpr.setSzCs(fontSize);
                rpr.setSz(fontSize);
                //设置粗体
                BooleanDefaultTrue bold = factory.createBooleanDefaultTrue();
                bold.setVal(Boolean.TRUE);
                rpr.setB(bold);
                //设置斜体
                BooleanDefaultTrue ltalic = new BooleanDefaultTrue();
                rpr.setI(ltalic);
                //设置删除线
                BooleanDefaultTrue deleteLine = new BooleanDefaultTrue();
                deleteLine.setVal(Boolean.TRUE);
                rpr.setStrike(deleteLine);
                //设置下划线
                U u = factory.createU();
                u.setVal(UnderlineEnumeration.SINGLE);
                u.setVal(UnderlineEnumeration.DOUBLE);//双下划线
                u.setVal(UnderlineEnumeration.DASH);//虚线
                u.setVal(UnderlineEnumeration.WAVE);//波浪线
                rpr.setU(u);
                Text text = factory.createText();
                text.setValue("雪地里走");
                R r = factory.createR();

                r.getContent().add(text);

                r.setRPr(rpr);

                P p = factory.createP();
                p.getContent().add(r);

                tc.getContent().add(p);
                tr.getContent().add(tc);

            }
            table.getContent().add(tr);
        }

        mainDocumentPart.addObject(table);


        wordMLPackage.save(new File("/Users/fnozoszzt/helloworld.docx"));



        URL simsunUrl = Main.class.getClassLoader().getResource("simsun.ttc");
        System.out.println("simsunUrl " + simsunUrl);
        PhysicalFonts.addPhysicalFonts("SimSun", simsunUrl);
        //PhysicalFont simsunFont = PhysicalFonts.get("SimSun");
        //fontMapper.put("宋体", simsunFont);


        Mapper fontMapper = new IdentityPlusMapper();
        //中文字体转换
        fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
        fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
        fontMapper.put("宋体",PhysicalFonts.get("SimSun"));
        fontMapper.put("微软雅黑",PhysicalFonts.get("Microsoft Yahei"));
        fontMapper.put("黑体",PhysicalFonts.get("SimHei"));
        fontMapper.put("楷体",PhysicalFonts.get("KaiTi"));
        fontMapper.put("新宋体",PhysicalFonts.get("NSimSun"));
        fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
        fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
        fontMapper.put("宋体扩展",PhysicalFonts.get("simsun-extB"));
        fontMapper.put("仿宋",PhysicalFonts.get("FangSong"));
        fontMapper.put("仿宋_GB2312",PhysicalFonts.get("FangSong_GB2312"));
        fontMapper.put("幼圆",PhysicalFonts.get("YouYuan"));
        fontMapper.put("华文宋体",PhysicalFonts.get("STSong"));
        fontMapper.put("华文中宋",PhysicalFonts.get("STZhongsong"));
        fontMapper.put("SimHei",PhysicalFonts.get("SimHei"));
        wordMLPackage.setFontMapper(fontMapper);


        OutputStream os = new java.io.FileOutputStream("/Users/fnozoszzt/helloworld2.pdf");
        FOSettings foSettings = Docx4J.createFOSettings();
        foSettings.setWmlPackage(wordMLPackage);
        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
        //IOUtils.closeQuietly(os);
        os.close();

    }
}
