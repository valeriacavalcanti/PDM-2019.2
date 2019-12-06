//
//  ViewController.swift
//  Memorias
//
//  Created by Valéria Cavalcanti on 06/12/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var tfAssunto: UITextField!
    @IBOutlet weak var swGostou: UISwitch!
    @IBOutlet weak var tvComentarios: UITextView!
    @IBOutlet weak var stNota: UIStepper!
    @IBOutlet weak var slRecomendacao: UISlider!
    @IBOutlet weak var lbNota: UILabel!
    @IBOutlet weak var lbRecomendacao: UILabel!
    
    var dao: MemoriaDAO!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.dao = MemoriaDAO()
    }
    
    @IBAction func definirNota(_ sender: Any) {
        self.lbNota.text = String(Int(self.stNota.value))
    }
    
    @IBAction func definirRecomendacao(_ sender: Any) {
        self.lbRecomendacao.text = String(Int(self.slRecomendacao.value))
    }
    
    @IBAction func salvar(_ sender: Any) {
        let assunto = self.tfAssunto.text
        let gostou = self.swGostou.isOn
        let comentarios = self.tvComentarios.text
        let nota = Int(self.stNota.value)
        let recomendacao = Int(self.slRecomendacao.value)
        
        if (self.dao.add(assunto: assunto!, gostou: gostou, comentarios: comentarios!, nota: nota, recomendacao:  recomendacao)){
            let alert = UIAlertController(title: "Atenção", message: "Deu certo", preferredStyle: UIAlertController.Style.alert)
            
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { (UIAlertAction) in
                self.navigationController?.popViewController(animated: true)
            }))
            
            self.present(alert, animated: true, completion: nil)
        }else{
            let alert = UIAlertController(title: "Atenção", message: "Deu problema", preferredStyle: UIAlertController.Style.alert)
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.cancel, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
    }
    
}

