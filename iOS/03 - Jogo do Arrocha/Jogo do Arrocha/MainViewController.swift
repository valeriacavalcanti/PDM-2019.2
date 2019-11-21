//
//  ViewController.swift
//  Jogo do Arrocha
//
//  Created by Valéria Cavalcanti on 14/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {

    @IBOutlet weak var lbMenor: UILabel!
    @IBOutlet weak var lbMaior: UILabel!
    @IBOutlet weak var lbChute: UILabel!
    @IBOutlet weak var slChute: UISlider!
    
    @IBAction func definirChute(_ sender: Any) {
        self.lbChute.text = String(Int(self.slChute.value))
    }
    
    @IBAction func novoJogo(_ sender: Any) {
        
    }
    
    @IBAction func chutar(_ sender: Any) {
        
    }
    
}

