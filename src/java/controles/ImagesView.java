/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author 1511 IRON
 */
@ManagedBean
public class ImagesView {
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        
        images.add("quarto1.jpg");
        images.add("quarto2.jpg");
        images.add("quarto3.jpg");
        images.add("quarto4.jpg");
        images.add("quarto5.jpg");
    }
 
    public List<String> getImages() {
        return images;
    }
}