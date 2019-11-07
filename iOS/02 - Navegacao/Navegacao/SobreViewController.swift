//
//  SobreViewController.swift
//  Navegacao
//
//  Created by Valéria Cavalcanti on 07/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
    @IBOutlet weak var lbNome: UILabel!
    var pessoa: Pessoa!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("Sobre: ViewDidLoad")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        print("Sobre: ViewWillAppear")
        
        //self.lbNome.text = self.pessoa.nome
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        print("Sobre: ViewDidAppear")
        
        self.lbNome.text = self.pessoa.nome
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        
        print("Sobre: ViewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        
        print("Sobre: ViewDidDisappear")
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.dismiss(animated: true, completion: nil)
    }
}
