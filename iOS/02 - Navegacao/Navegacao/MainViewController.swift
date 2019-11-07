//
//  ViewController.swift
//  Navegacao
//
//  Created by Valéria Cavalcanti on 07/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var slIdade: UISlider!
    @IBOutlet weak var lbIdade: UILabel!
    
    
    @IBAction func escolherIdade(_ sender: Any) {
        self.lbIdade.text = String(Int(self.slIdade.value))
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "main_sobre"){
            let svc = segue.destination as! SobreViewController
            
            let nome = self.tfNome.text
            let idade = Int(self.slIdade.value)
            
            svc.pessoa = Pessoa(nome: nome!, idade: idade)
        }
    }
}

