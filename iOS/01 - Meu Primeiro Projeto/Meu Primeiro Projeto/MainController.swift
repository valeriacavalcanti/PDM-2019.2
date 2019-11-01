//
//  ViewController.swift
//  Meu Primeiro Projeto
//
//  Created by Valéria Cavalcanti on 01/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class MainController: UIViewController {

    @IBOutlet weak var tfFrase: UITextField!
    @IBOutlet weak var slNota: UISlider!
    @IBOutlet weak var swNota: UISwitch!
    @IBOutlet weak var stNota: UIStepper!
    @IBOutlet weak var lbFrase: UILabel!
    @IBOutlet weak var lbSlider: UILabel!
    @IBOutlet weak var lbStepper: UILabel!
    
    @IBAction func copiar(_ sender: Any) {
        let notaSlider = self.slNota.value
        let notaStepper = self.stNota.value
        
        self.lbFrase.text = self.tfFrase.text
        print(notaSlider)
        print(notaStepper)
    }
    
    @IBAction func definirNotaSlider(_ sender: Any) {
        self.lbSlider.text = String(Int(self.slNota.value))
    }
    
    @IBAction func definirNotaStepper(_ sender: Any) {
        self.lbStepper.text = String(Int(self.stNota.value))
    }
}

